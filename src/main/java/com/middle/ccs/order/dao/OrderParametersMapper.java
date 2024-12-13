package com.middle.ccs.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.middle.ccs.order.entity.po.OrderParameters;
import org.apache.ibatis.annotations.Mapper;
/**
 * (OrderParameters)表数据库访问层
 *
 * @author 文亮
 * @since 2024-04-01 01:07:59
 */
@Mapper
public interface OrderParametersMapper extends BaseMapper<OrderParameters> {
}
