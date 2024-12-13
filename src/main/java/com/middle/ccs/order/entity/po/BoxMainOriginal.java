package com.middle.ccs.order.entity.po;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @classDesc: 实体类:(BoxMain)
 * @author: makejava
 * @date: 2023-06-22 00:04:43
 * @copyright 众阳健康
 */
@Data
@TableName("box_main_original")
public class BoxMainOriginal {
    private static final long serialVersionUID = -62876170078552644L;
    /**
    * 箱子主键id
    */
    @TableId
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
     * 箱子实际圈数
     */
    private Integer numberTurns;

    /**
     * 是否合格
     */
    private String qualified;

    /**
     * 不合格原因
     */
    private String failReason;

}
