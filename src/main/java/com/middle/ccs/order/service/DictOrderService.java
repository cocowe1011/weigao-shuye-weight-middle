package com.middle.ccs.order.service;

import com.middle.ccs.order.entity.po.DictOrder;
import com.middle.ccs.order.entity.po.OrderMain;

import java.util.List;

/**
 * 功能描述: 订单业务逻辑层
 * @author 文亮
 * @since 2023年06月09日01:31:21
 */
public interface DictOrderService {
    /**
     * 保存
     * @param dictOrder
     * @return
     */
    Integer save(DictOrder dictOrder);

    /**
     * 获取订单列表
     * @return
     */
    List<DictOrder> getDictOrder();

    /**
     * 保存
     * @param dictOrder
     * @return
     */
    Integer update(DictOrder dictOrder);

}
