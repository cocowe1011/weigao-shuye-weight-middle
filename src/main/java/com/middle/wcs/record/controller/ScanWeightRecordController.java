package com.middle.wcs.record.controller;

import com.github.pagehelper.PageInfo;
import com.middle.wcs.hander.ResponseResult;
import com.middle.wcs.record.entity.po.ScanWeightRecord;
import com.middle.wcs.record.service.ScanWeightRecordService;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * (ScanWeightRecord)控制器
 *
 * @author makejava
 * @since 2025-09-16 15:51:26
 */

@RestController
@Api(tags = "")
@RequestMapping("/scan_weight_record")
public class  ScanWeightRecordController {

    @Resource
    private ScanWeightRecordService scanWeightRecordService;
    
  /**
    * 保存
    *
    * @param dto 数据传输对象
    */
    @ApiOperation("保存")
    @PostMapping("/save")
    public ResponseResult<Integer> save(@ApiParam(value ="信息",required = true) @RequestBody ScanWeightRecord dto) {
        return ResponseResult.success(this.scanWeightRecordService.save(dto));
    }
    
/**
    * 更新
    *
    * @param  dto
    */
    @ApiOperation("更新")
    @PostMapping("/update")
    public ResponseResult<Integer> update(@ApiParam(value = "信息",required = true) @RequestBody ScanWeightRecord dto) {
        return ResponseResult.success(this.scanWeightRecordService.update(dto));
    }

    /**
     * 综合查询-分页
     * @param dto 订单信息（包含分页参数和查询条件）
     * @return 分页查询结果
     */
    @ApiOperation("综合查询-分页")
    @PostMapping("/selectListByPage")
    public ResponseResult<PageInfo<ScanWeightRecord>> selectListByPage(@ApiParam(value = "订单信息（包含分页参数和查询条件）", required = true) @RequestBody ScanWeightRecord dto) {
        return ResponseResult.success(this.scanWeightRecordService.selectListByPage(dto));
    }
}
