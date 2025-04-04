package com.middle.wcs.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.middle.wcs.order.entity.dto.OrderInfoPageDTO;
import com.middle.wcs.order.entity.po.OrderInfo;
import com.middle.wcs.order.dao.OrderInfoMapper;
import com.middle.wcs.order.service.OrderInfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import static com.github.pagehelper.page.PageMethod.startPage;

/**
 * (OrderInfo)服务实现类
 *
 * @author makejava
 * @since 2024-12-28 23:59:48
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    
    @Resource
    private OrderInfoMapper orderInfoMapper;
    
    @Override
    public Integer save(OrderInfo orderInfo) {
        return orderInfoMapper.insert(orderInfo);
    }
    
    @Override
    public Integer update(OrderInfo orderInfo) {
        return orderInfoMapper.updateById(orderInfo);
    }
    
    @Override
    public OrderInfo getOrderInfoById(Long id) {
        return orderInfoMapper.selectById(id);
    }
    
    @Override
    public List<OrderInfo> queryOrderList() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setInvalidFlag("0");
        QueryWrapper<OrderInfo> wrapper= new QueryWrapper<>(orderInfo);
        wrapper.ne("order_status", 3);
        wrapper.orderByDesc("order_status").orderByAsc("insert_time");
        return orderInfoMapper.selectList(wrapper);
    }

    @Override
    public PageInfo<OrderInfo> queryHistoryOrderList(OrderInfoPageDTO dto) {
        // 分页查询当前时段的预约患者
        Page<OrderInfo> page = startPage(dto.getPageNum(), dto.getPageSize());
        orderInfoMapper.queryHistoryOrderList(dto);
        PageInfo<OrderInfo> voPage = new PageInfo<>(page);
        return voPage;
    }

    @Override
    public OrderInfo getNowRunningOrder() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setInvalidFlag("0");
        QueryWrapper<OrderInfo> wrapper= new QueryWrapper<>(orderInfo);
        wrapper.eq("order_status", 1);
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(wrapper);
        if (orderInfos != null && orderInfos.size() > 0) {
            return orderInfos.get(0);
        }
        return null;
    }

    @Override
    public OrderInfo getOrderInfoByBatchId(Long batchId) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setInvalidFlag("0");
        QueryWrapper<OrderInfo> wrapper= new QueryWrapper<>(orderInfo);
        wrapper.eq("batch_id", batchId);
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(wrapper);
        if (orderInfos != null && orderInfos.size() > 0) {
            return orderInfos.get(0);
        }
        return null;
    }
}
