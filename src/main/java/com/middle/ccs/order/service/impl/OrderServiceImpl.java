package com.middle.ccs.order.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.middle.ccs.order.dao.BoxServiceMapper;
import com.middle.ccs.order.dao.OrderServiceMapper;
import com.middle.ccs.order.entity.dto.OrderMainSaveDTO;
import com.middle.ccs.order.entity.dto.ReportListDTO;
import com.middle.ccs.order.entity.dto.ReportListPageDTO;
import com.middle.ccs.order.entity.po.BoxMain;
import com.middle.ccs.order.entity.po.OrderMain;
import com.middle.ccs.order.entity.vo.BoxMainVO;
import com.middle.ccs.order.entity.vo.OrderMainReportVO;
import com.middle.ccs.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.github.pagehelper.page.PageMethod.startPage;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderServiceMapper orderServiceMapper;

    @Resource
    private BoxServiceMapper boxServiceMapper;

    /**
     * 保存
     * @return
     */
    @Override
    public Integer save(OrderMainSaveDTO orderMainSaveDTO) {
        OrderMain orderMain = new OrderMain();
        BeanUtils.copyProperties(orderMainSaveDTO, orderMain);
        return orderServiceMapper.insert(orderMain);
    }

    /**
     * 获取订单列表
     * @return
     */
    @Override
    public List<OrderMain> getOrderList() {
        return orderServiceMapper.getOrderList();
    }

    /**
     * 获取箱报告数据
     * @return
     */
    @Override
    public List<OrderMainReportVO> getOrderMainReport(ReportListDTO reportListDTO) {
        // 计算实际上货箱数 查询订单编号下箱子列表
        List<BoxMain> boxList = boxServiceMapper.getBoxInfoByOrderId(reportListDTO);
        int passTotal = 0;
        String passStr = "";
        int unpassTotal = 0;
        String unPassStr = "";
        for (BoxMain bm: boxList) {
            if("1".equals(bm.getQualified())) {
                passTotal++;
                passStr += ("".equals(passStr)?"":"，") + bm.getBoxImitateId();
            } else {
                unpassTotal++;
                unPassStr += ("".equals(unPassStr)?"":"，") + bm.getBoxImitateId();
            }
        }
        // 获取批报告模板，排除质量不合格的箱子，避免影响最值，均值统计
        List<OrderMainReportVO> lvo = orderServiceMapper.getOrderMainReportExcludeUnqualified(reportListDTO);
        if(null == lvo || lvo.size() == 0) {
            lvo = orderServiceMapper.getOrderMainReport(reportListDTO);
        }
        for (OrderMainReportVO orv: lvo) {
            orv.setOrderTotal(boxList.size());
            orv.setPassTotal(passTotal);
            orv.setUnpassTotal(unpassTotal);
            orv.setPassStr(passStr);
            orv.setUnpassStr(unPassStr);
        }
        return lvo;
    }

    /**
     * 更新
     * @param orderMain
     * @return
     */
    @Override
    public Integer update(OrderMain orderMain) {
        return orderServiceMapper.updateById(orderMain);
    }

    /**
     * 查询批报告
     * @param reportListDTO
     * @return
     */
    @Override
    public PageInfo<BoxMainVO> getReportList(ReportListPageDTO reportListDTO) {
        // 分页查询当前时段的预约患者
        Page<BoxMainVO> page = startPage(reportListDTO.getPageNum(), reportListDTO.getPageSize());
        orderServiceMapper.getReportList(reportListDTO);
        PageInfo<BoxMainVO> voPage = new PageInfo<>(page);
        return voPage;
    }

    /**
     * 获取当前运行订单列表
     * @return
     */
    @Override
    public OrderMain getNowRunOrder() {
        return orderServiceMapper.getNowRunOrder();
    }

    /**
     * 查询批报告
     * @param reportListDTO
     * @return
     */
    @Override
    public PageInfo<OrderMain> getOrderList400(ReportListPageDTO reportListDTO) {
        // 分页查询当前时段的预约患者
        Page<OrderMain> page = startPage(reportListDTO.getPageNum(), reportListDTO.getPageSize());
        orderServiceMapper.getOrderList400(reportListDTO);
        PageInfo<OrderMain> voPage = new PageInfo<>(page);
        return voPage;
    }
}
