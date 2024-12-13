package com.middle.ccs.order.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @classDesc: 实体类:(OrderMain)
 * @author: makejava
 * @date: 2023-06-09 01:36:55
 */
@Data
@TableName("order_main")
public class OrderMain  {
    private static final long serialVersionUID = -14336138781844056L;
    /**
    * 主键
    */    
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;
            
    /**
    * 订单编号
    */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderNo;
                
    /**
    * 订单名称
    */    
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
    private String batchId;
                
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
    private BigDecimal sxSpeedSet;

    /**
     * 束下速度上限
     */
    private BigDecimal sxSpeedUpperLimit;

    /**
     * 束下速度下限
     */
    private BigDecimal sxSpeedLowerLimit;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 订单开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 订单开结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 操作员
     */
    private String creatorName;

    /**
     * 订单日期，订单表创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createTime;
}
