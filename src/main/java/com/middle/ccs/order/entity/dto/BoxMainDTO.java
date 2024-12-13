package com.middle.ccs.order.entity.dto;
import com.middle.ccs.order.entity.po.BoxDetail;
import lombok.Data;

import java.util.List;

/**
 * @classDesc: 实体类:(BoxMain)
 * @author: makejava
 * @date: 2023-06-22 00:04:43
 */
@Data
public class BoxMainDTO {
            
    /**
    * 箱子模拟id
    */    
    private String boxImitateId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单号
     */
    private Long orderNo;

    /**
    * 上货扫码信息
    */    
    private String loadScanCode;

    /**
     * 圈数list
     */
    private List<BoxDetail> turnsInfoList;

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
