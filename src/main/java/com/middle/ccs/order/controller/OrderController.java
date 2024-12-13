package com.middle.ccs.order.controller;

import com.github.pagehelper.PageInfo;
import com.middle.ccs.hander.ResponseResult;
import com.middle.ccs.order.entity.dto.OrderMainSaveDTO;
import com.middle.ccs.order.entity.dto.ReportListDTO;
import com.middle.ccs.order.entity.dto.ReportListPageDTO;
import com.middle.ccs.order.entity.po.OrderMain;
import com.middle.ccs.order.entity.vo.BoxMainVO;
import com.middle.ccs.order.entity.vo.OrderMainReportVO;
import com.middle.ccs.order.service.OrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 订单业务层
 * @author 文亮
 */
@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    @Resource
    private OrderService orderService;


    /**
     * 保存方法
     * @param orderMainSaveDTO
     * @return
     */
    @RequestMapping("/save")
    public ResponseResult<Integer> save(@Valid @RequestBody OrderMainSaveDTO orderMainSaveDTO) {
        return ResponseResult.success(orderService.save(orderMainSaveDTO));
    }

    /**
     * 保存方法
     * @param orderMain
     * @return
     */
    @RequestMapping("/update")
    public ResponseResult<Integer> update(@RequestBody OrderMain orderMain) {
        return ResponseResult.success(orderService.update(orderMain));
    }

    /**
     * 或者订单列表
     * @return
     */
    @RequestMapping("/getOrderList")
    public ResponseResult<List<OrderMain>> getOrderList() {
        return ResponseResult.success(orderService.getOrderList());
    }

    /**
     * 获取批报告模板
     * @return
     */
    @RequestMapping("/getOrderMainReport")
    public ResponseResult<List<OrderMainReportVO>> getOrderMainReport(@RequestBody ReportListDTO reportListDTO) {
        return ResponseResult.success(orderService.getOrderMainReport(reportListDTO));
    }

    /**
     * 查询批报告
     * @return
     */
    @RequestMapping("/getReportList")
    public ResponseResult<PageInfo<BoxMainVO>> getReportList(@RequestBody ReportListPageDTO reportListDTO) {
        return ResponseResult.success(orderService.getReportList(reportListDTO));
    }

    /**
     * 获取当前正在运行的订单
     * @return
     */
    @RequestMapping("/getNowRunOrder")
    public ResponseResult<OrderMain> getNowRunOrder() {
        return ResponseResult.success(orderService.getNowRunOrder());
    }

    /**
     * 或者订单列表-400状态
     * @return
     */
    @RequestMapping("/getOrderList400")
    public ResponseResult<PageInfo<OrderMain>> getOrderList400(@RequestBody ReportListPageDTO reportListPageDTO) {
        return ResponseResult.success(orderService.getOrderList400(reportListPageDTO));
    }
}
