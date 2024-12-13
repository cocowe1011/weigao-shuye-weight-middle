package com.middle.ccs.order.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.middle.ccs.order.dao.*;
import com.middle.ccs.order.entity.dto.*;
import com.middle.ccs.order.entity.po.*;
import com.middle.ccs.order.entity.vo.BoxDetailVO;
import com.middle.ccs.order.service.BoxService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Service
@Slf4j
public class BoxServiceImpl implements BoxService {

    @Resource
    private BoxServiceMapper boxServiceMapper;

    @Resource
    private BoxDetailServiceMapper boxDetailServiceMapper;

    @Resource
    private OrderServiceMapper orderServiceMapper;

    @Resource
    private OrderOriginalServiceMapper orderOriginalServiceMapper;

    @Resource
    private BoxOriginalServiceMapper boxOriginalServiceMapper;

    @Resource
    private BoxDetailOriginalServiceMapper boxDetailOriginalServiceMapper;

    @Resource
    private OrderParametersMapper orderParametersMapper;

    private OrderParameters orderParameters = new OrderParameters();

    /**
     * 保存
     * @return 保存成功行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer save(BoxMainNewDTO boxMainNewDTO) {
        int i = 0;
        List<BoxMainDTO> boxMainDTO = boxMainNewDTO.getBoxMainDTOList();
        for (BoxMainDTO entity: boxMainDTO) {
            // 判断是更新还是新增
            BoxMain boxMainTemp = boxServiceMapper.getBoxInfoByBoxImitateId(entity);
            if(null != boxMainTemp) {
                // 已经有箱报告，把原来的箱报告和明细删除掉，在下面重新生成
                i = boxServiceMapper.deleteBoxInfoByBoxId(boxMainTemp.getBoxId());
                if(i < 1) {
                    throw new RuntimeException();
                }
                // 再把boxImitateId的明细删掉
                boxServiceMapper.deleteBoxDetailByBoxImitateId(boxMainTemp.getBoxImitateId());
            }
            // 新增
            BoxMain boxMain = new BoxMain();
            BeanUtils.copyProperties(entity, boxMain);
            i = boxServiceMapper.insert(boxMain);
            if(i != 1) {
                throw new RuntimeException();
            }
            List<BoxDetail> boxDetailList = entity.getTurnsInfoList();
            for (BoxDetail boxDetail : boxDetailList) {
                boxDetail.setBoxImitateId(entity.getBoxImitateId());
                boxDetail.setOrderId(entity.getOrderId());
                i = boxDetailServiceMapper.insert(boxDetail);
                if(i != 1) {
                    throw new RuntimeException();
                }
            }
        }
        // 更新订单状态,只有完成批报告才更新状态
        if(boxMainNewDTO.getFinishOrder()) {
            OrderMain orderMain = new OrderMain();
            orderMain.setOrderId(boxMainNewDTO.getOrderId());
            orderMain.setOrderStatus(400);
            orderMain.setEndTime(new Date());
            i = this.orderServiceMapper.updateById(orderMain);
        }
//        if(i != 1) {
//            throw new RuntimeException();
//        }
        return i;
    }


    /**
     * 保存-原始记录
     * @return 保存成功行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveOriginal(BoxMainNewDTO boxMainNewDTO) {
        int i = 0;
        List<BoxMainDTO> boxMainDTO = boxMainNewDTO.getBoxMainDTOList();
        for (BoxMainDTO entity: boxMainDTO) {
            // 箱子插入原纪录表
            BoxMainOriginal boxMainOriginal = new BoxMainOriginal();
            BeanUtils.copyProperties(entity, boxMainOriginal);
            i = this.boxOriginalServiceMapper.insert(boxMainOriginal);
            if(i != 1) {
                throw new RuntimeException();
            }
            List<BoxDetail> boxDetailList = entity.getTurnsInfoList();
            for (BoxDetail boxDetail : boxDetailList) {
                boxDetail.setBoxImitateId(entity.getBoxImitateId());
                // 插入原纪录表
                BoxDetailOriginal boxDetailOriginal = new BoxDetailOriginal();
                BeanUtils.copyProperties(boxDetail, boxDetailOriginal);
                i = this.boxDetailOriginalServiceMapper.insert(boxDetailOriginal);
                if(i != 1) {
                    throw new RuntimeException();
                }
            }
        }
        OrderMain orderMain = new OrderMain();
        orderMain.setOrderId(boxMainNewDTO.getOrderId());
        // 把原始记录存到原始记录表
        OrderMain OrderMain2 = this.orderServiceMapper.getOrderListByOrderId(orderMain);
        OrderMainOriginal orderMainOriginal = new OrderMainOriginal();
        BeanUtils.copyProperties(OrderMain2, orderMainOriginal);
        this.orderOriginalServiceMapper.insert(orderMainOriginal);
        return i;
    }

    /**
     * 获取今日0~9999编号
     * @return 编号
     */
    @Override
    public Integer getId() {
        return boxServiceMapper.getId();
    }

    /**
     * 获取箱报告数据
     * @return
     */
    @Override
    public List<BoxDetailVO> getBoxReport(ReportListDTO reportListDTO) {
        // 整表关联
        return boxServiceMapper.getBoxReport(reportListDTO);
    }

    @Override
    public OrderParameters getAccDataByLocal() {
        return boxServiceMapper.getAccDataByLocal();
    }

    @Override
    public BoxDetailVO getBoxReportLatest(ReportLatestDTO reportListDTO) {
        return boxServiceMapper.getBoxReportLatest(reportListDTO);
    }

    /**
     * 获取箱报告数据
     * @return
     */
    @Override
    public List<BoxMain> getBoxReportByOrderId(ReportListDTO reportListDTO) {
        // 整表关联
        return boxServiceMapper.getBoxInfoByOrderIdDesc(reportListDTO);
    }

    /**
     * 保存
     * @return 保存成功行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addBox(AddBoxDTO addBoxDTO) {
        // 查询
        BoxMain boxMain = new BoxMain();
        boxMain.setBoxImitateId(addBoxDTO.getBoxImitateId());
        QueryWrapper<BoxMain> wrapper= new QueryWrapper<>(boxMain);
        BoxMain boxMainCopy = boxServiceMapper.selectOne(wrapper);
        BoxDetail boxDetail = new BoxDetail();
        boxDetail.setBoxImitateId(addBoxDTO.getBoxImitateId());
        QueryWrapper<BoxDetail> wrapper2 = new QueryWrapper<>(boxDetail);
        List<BoxDetail> boxDetailList = boxDetailServiceMapper.selectList(wrapper2);
        // 获取一个最新的模拟id
        Integer beginNum = boxServiceMapper.getId();
        String newBoxImitateId = DateUtil.today().replaceAll("-", "").concat(StringUtils.leftPad(String.valueOf(beginNum + 1), 4, "0"));
        // 替换新的模拟id，插入
        boxMainCopy.setBoxImitateId(newBoxImitateId);
        boxMainCopy.setBoxId(null);
        int i = boxServiceMapper.insert(boxMainCopy);
        if(i != 1) {
            throw new RuntimeException();
        }
        for (BoxDetail item : boxDetailList) {
            item.setBoxImitateId(newBoxImitateId);
            item.setBoxDetailId(null);
            item.setOrderId(addBoxDTO.getOrderId());
            i = boxDetailServiceMapper.insert(item);
            if(i != 1) {
                throw new RuntimeException();
            }
        }
        return i;
    }

    /**
     * 通过箱子模拟id删除
     * @param deleteBoxDTO 入参
     * @return 出参
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteBox(DeleteBoxDTO deleteBoxDTO) {
        BoxMain boxMain = new BoxMain();
        boxMain.setBoxImitateId(deleteBoxDTO.getBoxImitateId());
        boxMain.setOrderId(deleteBoxDTO.getOrderId());
        QueryWrapper<BoxMain> wrapper= new QueryWrapper<>(boxMain);
        boxServiceMapper.delete(wrapper);
        BoxDetail boxDetail = new BoxDetail();
        boxDetail.setBoxImitateId(deleteBoxDTO.getBoxImitateId());
        boxDetail.setOrderId(deleteBoxDTO.getOrderId());
        QueryWrapper<BoxDetail> wrapper2 = new QueryWrapper<>(boxDetail);
        boxDetailServiceMapper.delete(wrapper2);
        return 1;
    }

    /**
     * 修改箱子信息
     * @param boxMain 入参
     * @return 出参
     */
    @Override
    public Integer update(BoxMain boxMain) {
        return boxServiceMapper.updateById(boxMain);
    }

    /**
     * 获取箱报告数据
     * @return
     */
    @Override
    public List<BoxMainOriginal> getBoxOriginalReportByOrderId(ReportListDTO reportListDTO) {
        // 整表关联
        return boxServiceMapper.getBoxOriginalReportByOrderId(reportListDTO);
    }

    /**
     * 修改箱子信息
     * @param updateBoxImitateIdDTO 入参
     * @return 出参
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateBoxImitateId(UpdateBoxImitateIdDTO updateBoxImitateIdDTO) {
        // 更新模拟id
        this.boxServiceMapper.updateBoxImitateIdBox(updateBoxImitateIdDTO);
        // 更新圈数模拟id
        this.boxServiceMapper.updateBoxImitateIdBoxDetail(updateBoxImitateIdDTO);
        return 1;
    }

    /**
     * 同步加速器工艺数据
     * @return 加速器实体类
     */
    @Override
    public void synAccData() {
        ParametersAcc parametersAcc = boxServiceMapper.getAccData();
        if(null != parametersAcc) {
            BeanUtils.copyProperties(parametersAcc, orderParameters);
            orderParameters.setId(9);
            orderParametersMapper.updateById(orderParameters);
        }
    }

    /**
     * 恢复加速器工艺数据
     * @return 加速器实体类
     */
    @Override
    public Integer recoverAccData() {
        OrderParameters orderParameters = new OrderParameters();
        orderParameters.setBeam(0);
        orderParameters.setBeamOn("0");
        orderParameters.setEnergy(new BigDecimal(0));
        orderParameters.setPfn(new BigDecimal(0));
        orderParameters.setPower(new BigDecimal(0));
        orderParameters.setPps(0);
        orderParameters.setScanF(new BigDecimal(0));
        orderParameters.setScanW(0);
        orderParameters.setSpeed(new BigDecimal(0));
        orderParameters.setId(9);
        return orderParametersMapper.updateById(orderParameters);
    }

    @Override
    public ParametersAcc getAccData() {
        return boxServiceMapper.getAccData();
    }
}
