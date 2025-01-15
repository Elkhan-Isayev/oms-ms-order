package com.oms.msorder.model.request;

import com.oms.msorder.model.enumeration.OrderStatusType;
import lombok.Data;

@Data
public class UpdateOrderRequest {

    private Long customerId;
    private Long itemId;
    private OrderStatusType orderStatus;

}
