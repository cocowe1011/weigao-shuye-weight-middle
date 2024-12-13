package com.middle.ccs.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.middle.ccs.order.dao.DictOrderServiceMapper;
import com.middle.ccs.order.entity.po.DictOrder;
import com.middle.ccs.order.entity.po.OrderMain;
import com.middle.ccs.order.service.DictOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Service
@Slf4j
public class DictOrderServiceImpl implements DictOrderService {

    @Resource
    private DictOrderServiceMapper dictOrderServiceMapper;

    /**
     * 保存
     * @return
     */
    @Override
    public Integer save(DictOrder dictOrder) {
        return dictOrderServiceMapper.insert(dictOrder);
    }

    /**
     * 更新
     * @param dictOrder
     * @return
     */
    @Override
    public Integer update(DictOrder dictOrder) {
        return dictOrderServiceMapper.updateById(dictOrder);
    }

    /**
     * 获取订单列表
     * @return
     */
    @Override
    public List<DictOrder> getDictOrder() {
        DictOrder dictOrder = new DictOrder();
        dictOrder.setInvalidFlag("0");
        QueryWrapper<DictOrder> wrapper= new QueryWrapper<>(dictOrder);
        wrapper.orderByDesc("create_time");
        return dictOrderServiceMapper.selectList(wrapper);
    }
}
