package com.middle.ccs.order.entity.dto;

import lombok.Data;

/**
 * @author 文亮
 * @description 报表查询入参
 * @date 2023-06-2023/6/24-0:40
 */
@Data
public class ReportListDTO {
    /**
     * 订单编号
     */
    private Long orderNo;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 箱编号
     */
    private String boxImitateId;
}
