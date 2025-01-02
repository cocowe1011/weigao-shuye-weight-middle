package com.middle.ccs.order.controller;

import com.github.pagehelper.PageInfo;
import com.middle.ccs.hander.ResponseResult;
import com.middle.ccs.order.entity.po.OrderInfo;
import com.middle.ccs.order.entity.po.QueueInfo;
import com.middle.ccs.order.service.QueueInfoService;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (QueueInfo)控制器
 *
 * @author makejava
 * @since 2025-01-01 12:44:45
 */

@RestController
@Api(tags = "")
@RequestMapping("/queue_info")
public class  QueueInfoController {

    @Resource
    private QueueInfoService queueInfoService;


/**
    * 更新
    *
    * @param  dto
    */
    @ApiOperation("更新")
    @PostMapping("/update")
    public ResponseResult<Integer> update(@ApiParam(value = "信息",required = true) @RequestBody QueueInfo dto) {
        return ResponseResult.success(this.queueInfoService.update(dto));
    }

    /**
     * 查询队列信息列表
     * @return 出参
     */
    @ApiOperation("查询队列信息列表")
    @PostMapping("/queryQueueList")
    public ResponseResult<List<QueueInfo>> queryQueueList() {
        return ResponseResult.success(this.queueInfoService.queryQueueList());
    }

}
