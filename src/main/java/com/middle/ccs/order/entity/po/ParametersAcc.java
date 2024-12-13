package com.middle.ccs.order.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigDecimal;
/**
 * @classDesc: 实体类:(Parameters)
 * @author: makejava
 * @date: 2023-07-10 21:31:51
 * @copyright 众阳健康
 */
@Data
@TableName("parameters")
public class ParametersAcc {
                
    /**
    * 能量
    */    
    private BigDecimal energy;
                
    /**
    * 束流
    */    
    private Integer beam;
                
    /**
    * 传输速度
    */    
    private BigDecimal speed;
                
    /**
    * 功率
    */    
    private BigDecimal power;
                
    /**
    * 扫描频率
    */    
    private BigDecimal scanF;
                
    /**
    * 扫描宽度
    */    
    private Integer scanW;
                
    /**
    * PFN电压
    */    
    private BigDecimal pfn;
                
    /**
    * 重复频率
    */    
    private Integer pps;
                
    /**
    * 出束
    */    
    private String beamOn;
    
}
