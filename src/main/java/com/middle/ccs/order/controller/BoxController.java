package com.middle.ccs.order.controller;

import com.middle.ccs.hander.ResponseResult;
import com.middle.ccs.order.entity.dto.*;
import com.middle.ccs.order.entity.po.BoxMain;
import com.middle.ccs.order.entity.po.BoxMainOriginal;
import com.middle.ccs.order.entity.po.OrderParameters;
import com.middle.ccs.order.entity.po.ParametersAcc;
import com.middle.ccs.order.entity.vo.BoxDetailVO;
import com.middle.ccs.order.service.BoxService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 箱子操作控制层
 * @author 文亮
 */
@RestController
@RequestMapping("/box")
public class BoxController {

    @Resource
    private BoxService boxService;

    /**
     * 保存箱子信息
     * @param boxMainNewDTO 保存
     * @return 出参
     */
    @RequestMapping("/save")
    public ResponseResult<Integer> save(@RequestBody BoxMainNewDTO boxMainNewDTO) {
        return ResponseResult.success(boxService.save(boxMainNewDTO));
    }

    /**
     * 保存箱子信息-原始记录
     * @param boxMainNewDTO 保存
     * @return 出参
     */
    @RequestMapping("/saveOriginal")
    public ResponseResult<Integer> saveOriginal(@RequestBody BoxMainNewDTO boxMainNewDTO) {
        return ResponseResult.success(boxService.saveOriginal(boxMainNewDTO));
    }

    /**
     * 获取今日0~9999编号
     * @return 编号
     */
    @RequestMapping("/getId")
    public ResponseResult<Integer> getId() {
        return ResponseResult.success(boxService.getId());
    }

    /**
     * 获取箱报告模板
     * @return
     */
    @RequestMapping("/getBoxReport")
    public ResponseResult<List<BoxDetailVO>> getBoxReport(@RequestBody ReportListDTO reportListDTO) {
        return ResponseResult.success(boxService.getBoxReport(reportListDTO));
    }

    /**
     * 获取加速器工艺数据
     * @return 加速器实体类
     */
    @RequestMapping("/getAccDataByLocal")
    public ResponseResult<OrderParameters> getAccDataByLocal() {
        return ResponseResult.success(boxService.getAccDataByLocal());
    }

    /**
     * 获取加速器工艺数据
     * @return 加速器实体类
     */
    @RequestMapping("/getAccData")
    public ResponseResult<ParametersAcc> getAccData() {
        return ResponseResult.success(boxService.getAccData());
    }

    /**
     * 同步加速器工艺数据
     * @return 加速器实体类
     */
    @RequestMapping("/synAccData")
    public void synAccData() {
        boxService.synAccData();
    }

    /**
     * 恢复加速器工艺数据
     * @return 加速器实体类
     */
    @RequestMapping("/recoverAccData")
    public ResponseResult<Integer> recoverAccData() {
        return ResponseResult.success(boxService.recoverAccData());
    }

    /**
     * 通过订单id获取最新一次箱报告模板
     * @return
     */
    @RequestMapping("/getBoxReportLatest")
    public ResponseResult<BoxDetailVO> getBoxReportLatest(@RequestBody ReportLatestDTO reportListDTO) {
        return ResponseResult.success(boxService.getBoxReportLatest(reportListDTO));
    }

    /**
     * 获取箱报告模板
     * @return
     */
    @RequestMapping("/getBoxReportByOrderId")
    public ResponseResult<List<BoxMain>> getBoxReportByOrderId(@RequestBody ReportListDTO reportListDTO) {
        return ResponseResult.success(boxService.getBoxReportByOrderId(reportListDTO));
    }

    /**
     * 复制箱子信息-复制最后一个箱子
     * @param addBoxDTO 保存
     * @return 出参
     */
    @RequestMapping("/addBox")
    public ResponseResult<Integer> addBox(@RequestBody AddBoxDTO addBoxDTO) {
        return ResponseResult.success(boxService.addBox(addBoxDTO));
    }

    /**
     * 删除箱子及箱子明细
     * @param deleteBoxDTO 入参
     * @return 出参
     */
    @RequestMapping("/deleteBox")
    public ResponseResult<Integer> deleteBox(@RequestBody DeleteBoxDTO deleteBoxDTO) {
        return ResponseResult.success(boxService.deleteBox(deleteBoxDTO));
    }

    /**
     * 修改箱子信息
     * @param boxMain 入参
     * @return 出参
     */
    @RequestMapping("/update")
    public ResponseResult<Integer> update(@RequestBody BoxMain boxMain) {
        return ResponseResult.success(boxService.update(boxMain));
    }

    /**
     * 获取箱报告模板-原始记录
     * @return
     */
    @RequestMapping("/getBoxOriginalReportByOrderId")
    public ResponseResult<List<BoxMainOriginal>> getBoxOriginalReportByOrderId(@RequestBody ReportListDTO reportListDTO) {
        return ResponseResult.success(boxService.getBoxOriginalReportByOrderId(reportListDTO));
    }

    /**
     * 修改箱子信息
     * @param updateBoxImitateIdDTO 入参
     * @return 出参
     */
    @RequestMapping("/updateBoxImitateId")
    public ResponseResult<Integer> updateBoxImitateId(@RequestBody UpdateBoxImitateIdDTO updateBoxImitateIdDTO) {
        return ResponseResult.success(boxService.updateBoxImitateId(updateBoxImitateIdDTO));
    }
}
