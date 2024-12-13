package com.middle.ccs.order.controller;

import com.middle.ccs.hander.ResponseResult;
import com.middle.ccs.order.entity.po.DictOrder;
import com.middle.ccs.order.entity.po.OrderMain;
import com.middle.ccs.order.service.DictOrderService;
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
@RequestMapping("/dict")
@Validated
public class DictOrderController {

    @Resource
    private DictOrderService dictOrderService;


    /**
     * 保存方法
     * @param dictOrder
     * @return
     */
    @RequestMapping("/save")
    public ResponseResult<Integer> save(@Valid @RequestBody DictOrder dictOrder) {
        return ResponseResult.success(dictOrderService.save(dictOrder));
    }

    /**
     * 保存方法
     * @param dictOrder
     * @return
     */
    @RequestMapping("/update")
    public ResponseResult<Integer> update(@RequestBody DictOrder dictOrder) {
        return ResponseResult.success(dictOrderService.update(dictOrder));
    }

    /**
     * 或者订单列表
     * @return
     */
    @RequestMapping("/getDictOrder")
    public ResponseResult<List<DictOrder>> getDictOrder() {
        return ResponseResult.success(dictOrderService.getDictOrder());
    }
}
