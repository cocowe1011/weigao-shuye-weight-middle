package com.middle.ccs.order.service;


import com.github.pagehelper.PageInfo;
import com.middle.ccs.order.entity.dto.OrderMainSaveDTO;
import com.middle.ccs.order.entity.dto.ReportListDTO;
import com.middle.ccs.order.entity.dto.ReportListPageDTO;
import com.middle.ccs.order.entity.po.OrderMain;
import com.middle.ccs.order.entity.vo.BoxMainVO;
import com.middle.ccs.order.entity.vo.OrderMainReportVO;

import java.util.List;

/**
 * 功能描述: 订单业务逻辑层
 * @author 文亮
 * @since 2023年06月09日01:31:21
 */
public interface OrderService {
    /**
     * 保存
     * @param orderMainSaveDTO
     * @return
     */
    Integer save(OrderMainSaveDTO orderMainSaveDTO);

    /**
     * 获取订单列表
     * @return
     */
    List<OrderMain> getOrderList();

    /**
     * 获取批报告模板
     * @return
     */
    List<OrderMainReportVO> getOrderMainReport(ReportListDTO reportListDTO);

    /**
     * 保存
     * @param orderMain
     * @return
     */
    Integer update(OrderMain orderMain);

    /**
     * 查询批报告
     * @param reportListDTO
     * @return
     */
    PageInfo<BoxMainVO> getReportList(ReportListPageDTO reportListDTO);

    /**
     * 获取当前正在运行的订单
     * @return
     */
    OrderMain getNowRunOrder();

    /**
     * 或者订单列表-400状态
     * @return
     */
    PageInfo<OrderMain> getOrderList400(ReportListPageDTO reportListPageDTO);
}
