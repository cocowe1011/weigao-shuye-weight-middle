package com.middle.wcs.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.middle.wcs.order.entity.po.QueueInfo;
/**
 * (QueueInfo)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-01 12:44:45
 */
@Mapper
public interface QueueInfoMapper extends BaseMapper<QueueInfo> {

}
