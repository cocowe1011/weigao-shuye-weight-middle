package com.middle.ccs.order.entity.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * (OrderParameters)实体类
 *
 * @author 文亮
 * @since 2024-04-01 01:07:59
 */
@Data
@TableName("order_parameters")
public class OrderParameters{
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

    /**
    * 主键
    */
    @TableId
    private Integer id;
}
