package com.middle.ccs.order.entity.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * @classDesc: 实体类:(OrderMain)
 * @author: makejava
 * @date: 2023-06-09 01:36:55
 */
@Data
public class OrderMainSaveDTO {
            
    /**
    * 订单编号
    */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotEmpty(message = "订单编号不可为空")
    private Long orderNo;
                
    /**
    * 订单名称
    */
    @NotEmpty(message = "订单名称不可为空")
    private String orderName;
                
    /**
    * 是否翻转，0不翻转，1翻转
    */
    private String revertFlag;

    /**
     * 托盘模式
     */
    private String trayFlag;

    /**
     * 拍照模式
     */
    private String photoFlag;

    /**
    * 批次编号
    */
    @NotEmpty(message = "批次编号不可为空")
    private String batchId;
                
    /**
    * 产品名称
    */
    @NotEmpty(message = "产品名称不可为空")
    private String productName;
                
    /**
    * 工艺名称
    */
    @NotEmpty(message = "工艺名称不可为空")
    private String artName;
                
    /**
    * 装载方式
    */
    @NotEmpty(message = "装载方式不可为空")
    private String loadMethod;
                
    /**
    * 路径名称
    */
    @NotEmpty(message = "路径名称不可为空")
    private String pathName;
                
    /**
    * 圈数
    */
    @NotEmpty(message = "圈数不可为空")
    private Integer numberTurns;
                
    /**
    * 箱子长度
    */
    @NotEmpty(message = "箱子长度不可为空")
    private BigDecimal boxLength;
                
    /**
    * 箱子宽度
    */
    @NotEmpty(message = "箱子宽度不可为空")
    private BigDecimal boxWidth;
                
    /**
    * 箱子高度
    */
    @NotEmpty(message = "箱子高度不可为空")
    private BigDecimal boxHeight;
                
    /**
    * 箱子重量
    */
    @NotEmpty(message = "箱子重量不可为空")
    private BigDecimal boxWeight;
                
    /**
    * 束流上限
    */
    @NotEmpty(message = "束流上限不可为空")
    private Integer slUpperLimit;
                
    /**
    * 束流设定值
    */
    @NotEmpty(message = "束流设定值不可为空")
    private Integer slSet;
                
    /**
    * 束流下限值
    */
    @NotEmpty(message = "束流下限值不可为空")
    private Integer slLowerLimit;
                
    /**
    * 功率上限
    */
    @NotEmpty(message = "功率上限不可为空")
    private BigDecimal glUpperLimit;
                
    /**
    * 功率设定值
    */
    @NotEmpty(message = "功率设定值不可为空")
    private BigDecimal glSet;
                
    /**
    * 功率下限值
    */
    @NotEmpty(message = "功率下限值不可为空")
    private BigDecimal glLowerLimit;
                
    /**
    * 扫宽上限
    */
    @NotEmpty(message = "扫宽上限不可为空")
    private Integer skUpperLimit;
                
    /**
    * 扫宽设定值
    */
    @NotEmpty(message = "扫宽设定值不可为空")
    private Integer skSet;
                
    /**
    * 扫宽下限值
    */
    @NotEmpty(message = "扫宽下限值不可为空")
    private Integer skLowerLimit;
                
    /**
    * 扫描频率上限
    */
    @NotEmpty(message = "扫描频率上限不可为空")
    private BigDecimal smplUpperLimit;
                
    /**
    * 扫描频率设定值
    */
    @NotEmpty(message = "扫描频率设定值不可为空")
    private BigDecimal smplSet;
                
    /**
    * 扫描频率下限值
    */
    @NotEmpty(message = "扫描频率下限值不可为空")
    private BigDecimal smplLowerLimit;
                
    /**
    * PFN电压上限
    */
    @NotEmpty(message = "PFN电压上限值不可为空")
    private BigDecimal pfnUpperLimit;
                
    /**
    * PFN电压设定值
    */
    @NotEmpty(message = "PFN电压设定值不可为空")
    private BigDecimal pfnSet;
                
    /**
    * PFN电压下限值
    */
    @NotEmpty(message = "PFN电压下限值不可为空")
    private BigDecimal pfnLowerLimit;
                
    /**
    * 能量上限
    */
    @NotEmpty(message = "能量上限值不可为空")
    private BigDecimal nlUpperLimit;
                
    /**
    * 能量设定值
    */
    @NotEmpty(message = "能量设定值值不可为空")
    private BigDecimal nlSet;
                
    /**
    * 能量下限值
    */
    @NotEmpty(message = "能量下限值不可为空")
    private BigDecimal nlLowerLimit;
                
    /**
    * 订单箱数
    */
    @NotEmpty(message = "订单箱数不可为空")
    private Integer orderBoxNum;
                
    /**
    * 剔除箱数
    */    
    private Integer eliminateBoxNum;
                
    /**
    * 上货箱数
    */    
    private Integer exhibitBoxNum;
                
    /**
    * 合格箱数
    */    
    private Integer qualifiedBoxNum;

    /**
     * 束下速度
     */
    @NotEmpty(message = "束下速度不可为空")
    private BigDecimal sxSpeedSet;

    /**
     * 束下速度上限
     */
    @NotEmpty(message = "束下速度上限不可为空")
    private BigDecimal sxSpeedUpperLimit;

    /**
     * 束下速度下限
     */
    @NotEmpty(message = "束下速度下限不可为空")
    private BigDecimal sxSpeedLowerLimit;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 操作员
     */
    private String creatorName;

}
