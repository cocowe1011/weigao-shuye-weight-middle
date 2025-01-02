package com.middle.ccs.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.middle.ccs.order.entity.dto.OrderInfoPageDTO;
import org.apache.ibatis.annotations.Mapper;
import com.middle.ccs.order.entity.po.OrderInfo;

import java.util.List;

/**
 * (OrderInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-28 23:59:48
 */
@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    List<OrderInfo> queryHistoryOrderList(OrderInfoPageDTO dto);
}
