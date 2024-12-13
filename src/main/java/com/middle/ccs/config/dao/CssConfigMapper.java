package com.middle.ccs.config.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.middle.ccs.config.entity.CssConfig;
import org.apache.ibatis.annotations.Mapper;
/**
 * @classDesc: 数据访问接口:(CssConfig)
 * @author: makejava
 * @date: 2023-07-04 15:31:47
 * @copyright 众阳健康
 */
@Mapper
public interface CssConfigMapper extends BaseMapper<CssConfig> {


    CssConfig getConfig();
}
