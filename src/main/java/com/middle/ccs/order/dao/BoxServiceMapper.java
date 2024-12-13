package com.middle.ccs.order.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.middle.ccs.order.entity.dto.BoxMainDTO;
import com.middle.ccs.order.entity.dto.ReportLatestDTO;
import com.middle.ccs.order.entity.dto.ReportListDTO;
import com.middle.ccs.order.entity.dto.UpdateBoxImitateIdDTO;
import com.middle.ccs.order.entity.po.BoxMain;
import com.middle.ccs.order.entity.po.BoxMainOriginal;
import com.middle.ccs.order.entity.po.OrderParameters;
import com.middle.ccs.order.entity.po.ParametersAcc;
import com.middle.ccs.order.entity.vo.BoxDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Mapper
public interface BoxServiceMapper extends BaseMapper<BoxMain> {
    /**
     * 获取今日箱子上货数
     * @return 上货数量
     */
    Integer getId();

    /**
     * 获取箱报告模板
     * @param reportListDTO
     * @return
     */
    List<BoxDetailVO> getBoxReport(ReportListDTO reportListDTO);

    /**
     * 获取acc加速器数据
     * @return 出参
     */
    @DS("db2")
    ParametersAcc getAccData();

    /**
     * 获取箱子信息，判断箱报告有没有生成
     * @param entity
     * @return
     */
    BoxMain getBoxInfoByBoxImitateId(BoxMainDTO entity);

    /**
     * 删除箱报告
     * @param boxId
     * @return
     */
    Integer deleteBoxInfoByBoxId(@Param("boxId") Long boxId);

    /**
     * 删除明细
     * @param boxImitateId
     * @return
     */
    void deleteBoxDetailByBoxImitateId(@Param("boxImitateId") String boxImitateId);

    /**
     * 获取箱报告模板
     * @param reportListDTO
     * @return
     */
    BoxDetailVO getBoxReportLatest(ReportLatestDTO reportListDTO);

    /**
     * 通过orderNo获取所有箱子列表
     * @param reportListDTO
     * @return
     */
    List<BoxMain> getBoxInfoByOrderId(ReportListDTO reportListDTO);

    /**
     * 获取箱报告数据
     * @param reportListDTO
     * @return
     */
    List<BoxDetailVO> getBoxReportByOrderId(ReportListDTO reportListDTO);

    /**
     * 通过orderNo获取所有箱子列表
     * @param reportListDTO
     * @return
     */
    List<BoxMain> getBoxInfoByOrderIdDesc(ReportListDTO reportListDTO);

    /**
     * 获取箱报告数据-原始数据
     * @param reportListDTO
     * @return
     */
    List<BoxMainOriginal> getBoxOriginalReportByOrderId(ReportListDTO reportListDTO);

    /**
     * 更新
     * @param updateBoxImitateIdDTO
     */
    void updateBoxImitateIdBox(UpdateBoxImitateIdDTO updateBoxImitateIdDTO);

    /**
     * 更新
     * @param updateBoxImitateIdDTO
     */
    void updateBoxImitateIdBoxDetail(UpdateBoxImitateIdDTO updateBoxImitateIdDTO);

    /**
     * 查询本地映射的数据
     * @return
     */
    OrderParameters getAccDataByLocal();
}
