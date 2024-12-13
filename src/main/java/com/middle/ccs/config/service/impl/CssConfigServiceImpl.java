package com.middle.ccs.config.service.impl;

import com.middle.ccs.config.entity.CssConfig;
import com.middle.ccs.config.dao.CssConfigMapper;
import com.middle.ccs.config.entity.PcsConfig;
import com.middle.ccs.config.service.CssConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @classDesc: 业务逻辑:(CssConfig)
 * @author: makejava
 * @date: 2023-07-04 15:31:43
 * @copyright 众阳健康
 */
@Service
public class CssConfigServiceImpl implements CssConfigService {
    @Resource
    private CssConfigMapper cssConfigMapper;

    @Override
    public Integer update (CssConfig cssConfig) {
        return cssConfigMapper.updateById(cssConfig);
    }

    @Override
    public CssConfig getConfig() {
        return cssConfigMapper.getConfig();
    }

    @Override
    public Integer updatePcsConfig(PcsConfig pcsConfig) {
        return null;
    }

    @Override
    public PcsConfig getPcsConfig() {
        return null;
    }
}
