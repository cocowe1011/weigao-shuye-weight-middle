package com.middle.ccs.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.middle.ccs.order.entity.po.OrderMainOriginal;
import org.apache.ibatis.annotations.Mapper;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Mapper
public interface OrderOriginalServiceMapper extends BaseMapper<OrderMainOriginal> {
}
