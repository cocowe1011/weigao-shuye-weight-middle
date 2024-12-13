package com.middle.ccs.order.service;


import com.middle.ccs.order.entity.dto.*;
import com.middle.ccs.order.entity.po.BoxMain;
import com.middle.ccs.order.entity.po.BoxMainOriginal;
import com.middle.ccs.order.entity.po.OrderParameters;
import com.middle.ccs.order.entity.po.ParametersAcc;
import com.middle.ccs.order.entity.vo.BoxDetailVO;

import java.util.List;

/**
 * 功能描述: 箱子业务逻辑层
 * @author 文亮
 * @since 2023年06月09日01:31:21
 */
public interface BoxService {
    /**
     * 保存
     * @param boxMainNewDTO 保存
     * @return 出参
     */
    Integer save(BoxMainNewDTO boxMainNewDTO);


    /**
     * 保存-原始记录
     * @param boxMainNewDTO 保存
     * @return 出参
     */
    Integer saveOriginal(BoxMainNewDTO boxMainNewDTO);

    /**
     * 获取今日0~9999编号
     * @return 编号
     */
    Integer getId();

    /**
     * 获取项报告模板
     * @param reportListDTO
     * @return
     */
    List<BoxDetailVO> getBoxReport(ReportListDTO reportListDTO);

    /**
     * 获取acc加速器数据
     * @return
     */
    OrderParameters getAccDataByLocal();

    /**
     * 获取最新一次的箱报告
     * @param reportListDTO
     * @return
     */
    BoxDetailVO getBoxReportLatest(ReportLatestDTO reportListDTO);

    /**
     * 获取箱报告模板
     * @return
     */
    List<BoxMain> getBoxReportByOrderId(ReportListDTO reportListDTO);

    /**
     * 复制箱子信息-复制最后一个箱子
     * @param addBoxDTO 保存
     * @return 出参
     */
    Integer addBox(AddBoxDTO addBoxDTO);

    /**
     * 删除箱子及箱子明细
     * @param deleteBoxDTO 入参
     * @return 出参
     */
    Integer deleteBox(DeleteBoxDTO deleteBoxDTO);

    /**
     * 修改箱子信息
     * @param boxMain 入参
     * @return 出参
     */
    Integer update(BoxMain boxMain);

    /**
     * 获取箱报告模板-原始记录
     * @param reportListDTO
     * @return
     */
    List<BoxMainOriginal> getBoxOriginalReportByOrderId(ReportListDTO reportListDTO);

    /**
     * 修改箱子信息
     * @param updateBoxImitateIdDTO 入参
     * @return 出参
     */
    Integer updateBoxImitateId(UpdateBoxImitateIdDTO updateBoxImitateIdDTO);

    /**
     * 同步加速器工艺数据
     * @return 加速器实体类
     */
    void synAccData();

    /**
     * 恢复加速器工艺数据
     * @return 加速器实体类
     */
    Integer recoverAccData();

    /**
     * 获取acc加速器数据
     * @return
     */
    ParametersAcc getAccData();
}
