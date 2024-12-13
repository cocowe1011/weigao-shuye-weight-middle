package com.middle.ccs.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.middle.ccs.order.entity.dto.BoxMainNewDTO;
import com.middle.ccs.order.entity.dto.ReportListDTO;
import com.middle.ccs.order.entity.dto.ReportListPageDTO;
import com.middle.ccs.order.entity.po.OrderMain;
import com.middle.ccs.order.entity.vo.BoxMainVO;
import com.middle.ccs.order.entity.vo.OrderMainReportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Mapper
public interface OrderServiceMapper extends BaseMapper<OrderMain> {

    /**
     * 获取订单列表
     * @return
     */
    List<OrderMain> getOrderList();

    /**
     * 获取批报告模板
     * @param reportListDTO
     * @return
     */
    List<OrderMainReportVO> getOrderMainReport(ReportListDTO reportListDTO);

    /**
     * 获取批报告模板，排除质量不合格的箱子，避免影响最值，均值统计
     * @param reportListDTO
     * @return
     */
    List<OrderMainReportVO> getOrderMainReportExcludeUnqualified(ReportListDTO reportListDTO);

    /**
     * 查询批报告
     * @param reportListDTO
     * @return
     */
    List<BoxMainVO> getReportList(ReportListPageDTO reportListDTO);

    /**
     * 获取当前运行订单列表
     * @return
     */
    OrderMain getNowRunOrder();

    /**
     * 查询批报告
     * @param reportListDTO
     * @return
     */
    List<OrderMain> getOrderList400(ReportListPageDTO reportListDTO);

    /**
     * 通过orderId查询订单信息
     * @param orderMain
     * @return
     */
    OrderMain getOrderListByOrderId(OrderMain orderMain);
}
