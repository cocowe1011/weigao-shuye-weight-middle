package com.middle.ccs.order.entity.po;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
/**
 * @classDesc: 实体类:(BoxDetail)
 * @author: makejava
 * @date: 2023-06-22 00:05:18
 * @copyright 众阳健康
 */
@Data
@TableName("box_detail")
public class BoxDetail {
    private static final long serialVersionUID = 734798568677939848L;
    /**
    * 主键
    */
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long boxDetailId;
            
    /**
    * 箱子主键id
    */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long boxId;

    /**
     * 订单id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;

    /**
     * 箱子模拟id
     */
    private String boxImitateId;

    /**
    * 是否合格
    */    
    private String qualified;
                
    /**
    * 圈数
    */    
    private Integer numberTurns;
                
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
    
}
