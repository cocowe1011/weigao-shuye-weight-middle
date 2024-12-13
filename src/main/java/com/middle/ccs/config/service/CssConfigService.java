package com.middle.ccs.config.service;

import com.middle.ccs.config.entity.CssConfig;
import com.middle.ccs.config.entity.PcsConfig;

/**
 * @classDesc: 业务接口:(CssConfig)
 * @author: makejava
 * @date: 2023-07-04 15:31:45
 * @copyright 众阳健康
 */
public interface CssConfigService {

    Integer update(CssConfig cssConfig);

    CssConfig getConfig();

    Integer updatePcsConfig(PcsConfig pcsConfig);

    PcsConfig getPcsConfig();
}
