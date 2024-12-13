package com.middle.ccs.order.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 文亮
 * @description 新入参
 * @date 2023-07-2023/7/15-10:35
 */
@Data
public class BoxMainNewDTO {
    List<BoxMainDTO> boxMainDTOList;
    Boolean finishOrder;
    private Long orderId;
}
