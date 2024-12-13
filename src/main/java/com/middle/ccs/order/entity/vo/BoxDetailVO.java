package com.middle.ccs.order.entity.vo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @classDesc: 实体类:(BoxMain)
 * @author: makejava
 * @date: 2023-06-22 00:04:43
 * @copyright 众阳健康
 */
@Data
public class BoxDetailVO {
    /**
    * 箱子主键id
    */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long boxId;
                
    /**
    * 上货扫码信息
    */    
    private String loadScanCode;

    /**
     * 箱子模拟id
     */
    private String boxImitateId;

    /**
     * 订单id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;

    /**
     * 订单号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderNo;

    /**
     * 箱子当前第几圈
     */
    private Integer boxDetailNumberTurns;

    /**
     * 订单圈数
     */
    private Integer ddNumberTurns;

    /**
     * 箱子总圈数
     */
    private Integer boxNumberTurns;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long boxDetailId;

    /**
     * 是否合格
     */
    private String qualified;

    /**
     * 束流读取值
     */
    private Integer slRead;

    /**
     * 功率读取值
     */
    private BigDecimal glRead;

    /**
     * 扫宽读取值
     */
    private Integer skRead;

    /**
     * 扫描频率读取值
     */
    private BigDecimal smplRead;

    /**
     * PFN电压读取值
     */
    private BigDecimal pfnRead;

    /**
     * 能量读取值
     */
    private BigDecimal nlRead;

    /**
     * 束下速度读取值
     */
    private BigDecimal sxSpeedRead;

    /**
     * 辐射开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date radiationStartTime;

    /**
     * 辐射结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date radiationEndTime;

    /**
     * 经过A点时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date passATime;

    /**
     * 经过B点时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date passBTime;

    /**
     * 经过C点时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date passCTime;

    /**
     * 经过D点时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date passDTime;

    /**
     * 经过E点时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date passETime;

    /**
     * 经过F点时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date passFTime;

    /**
     * 经过G点时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date passGTime;

    /**
     * 经过H点时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date passHTime;

    /**
     * 订单名称
     */
    private String orderName;

    /**
     * 是否翻转，0不翻转，1翻转
     */
    private String revertFlag;

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
    private String slUpperLimit;

    /**
     * 束流设定值
     */
    private String slSet;

    /**
     * 束流下限值
     */
    private String slLowerLimit;

    /**
     * 功率上限
     */
    private String glUpperLimit;

    /**
     * 功率设定值
     */
    private String glSet;

    /**
     * 功率下限值
     */
    private String glLowerLimit;

    /**
     * 扫宽上限
     */
    private String skUpperLimit;

    /**
     * 扫宽设定值
     */
    private String skSet;

    /**
     * 扫宽下限值
     */
    private String skLowerLimit;

    /**
     * 扫描频率上限
     */
    private String smplUpperLimit;

    /**
     * 扫描频率设定值
     */
    private String smplSet;

    /**
     * 扫描频率下限值
     */
    private String smplLowerLimit;

    /**
     * PFN电压上限
     */
    private String pfnUpperLimit;

    /**
     * PFN电压设定值
     */
    private String pfnSet;

    /**
     * PFN电压下限值
     */
    private String pfnLowerLimit;

    /**
     * 能量上限
     */
    private String nlUpperLimit;

    /**
     * 能量设定值
     */
    private String nlSet;

    /**
     * 能量下限值
     */
    private String nlLowerLimit;

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
    private String sxSpeedSet;

    /**
     * 束下速度上限
     */
    private String sxSpeedUpperLimit;

    /**
     * 束下速度下限
     */
    private String sxSpeedLowerLimit;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 是否合格
     */
    private String boxQualified;

}
