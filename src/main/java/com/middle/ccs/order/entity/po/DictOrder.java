package com.middle.ccs.order.entity.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 订单主表(DictOrder)实体类
 *
 * @author 文亮
 * @since 2023-09-05 19:00:31
 */
@Data
@TableName("dict_order")
public class DictOrder{

    /**
    * 主键
    */
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long dictOrderId;

    /**
    * 订单名称
    */
    private String orderName;

    /**
     * 配方名称
     */
    private String dictName;

    /**
     * 托盘模式
     */
    private String trayFlag;

    /**
     * 拍照模式
     */
    private String photoFlag;

    /**
    * 是否翻转，0不翻转，1翻转
    */
    private String revertFlag;

    /**
    * 产品名称
    */
    private String productName;

    /**
    * 加速器k值
    */
    private String acceleratorKValue;

    /**
    * 工艺名称
    */
    private String artName;

    /**
    * 装载方式
    */
    private String loadMethod;

    /**
    * 路径名称
    */
    private String pathName;

    /**
    * 圈数
    */
    private Integer numberTurns;

    /**
    * 箱子长度
    */
    private BigDecimal boxLength;

    /**
    * 箱子宽度
    */
    private BigDecimal boxWidth;

    /**
    * 箱子高度
    */
    private BigDecimal boxHeight;

    /**
    * 箱子重量
    */
    private BigDecimal boxWeight;

    /**
    * 束流上限
    */
    private Integer slUpperLimit;

    /**
    * 束流设定值
    */
    private Integer slSet;

    /**
    * 束流下限值
    */
    private Integer slLowerLimit;

    /**
    * 功率上限
    */
    private BigDecimal glUpperLimit;

    /**
    * 功率设定值
    */
    private BigDecimal glSet;

    /**
    * 功率下限值
    */
    private BigDecimal glLowerLimit;

    /**
    * 扫宽上限
    */
    private Integer skUpperLimit;

    /**
    * 扫宽设定值
    */
    private Integer skSet;

    /**
    * 扫宽下限值
    */
    private Integer skLowerLimit;

    /**
    * 扫描频率上限
    */
    private BigDecimal smplUpperLimit;

    /**
    * 扫描频率设定值
    */
    private BigDecimal smplSet;

    /**
    * 扫描频率下限值
    */
    private BigDecimal smplLowerLimit;

    /**
    * PFN电压上限
    */
    private BigDecimal pfnUpperLimit;

    /**
    * PFN电压设定值
    */
    private BigDecimal pfnSet;

    /**
    * PFN电压下限值
    */
    private BigDecimal pfnLowerLimit;

    /**
    * 能量上限
    */
    private BigDecimal nlUpperLimit;

    /**
    * 能量设定值
    */
    private BigDecimal nlSet;

    /**
    * 能量下限值
    */
    private BigDecimal nlLowerLimit;

    /**
    * 订单箱数
    */
    private Integer orderBoxNum;

    /**
    * 作废标识，0未作废，1作废
    */
    private String invalidFlag;

    /**
    * 束下速度
    */
    private BigDecimal sxSpeedSet;

    /**
    * 束下速度上限
    */
    private BigDecimal sxSpeedUpperLimit;

    /**
    * 束下速度下限
    */
    private BigDecimal sxSpeedLowerLimit;
}
