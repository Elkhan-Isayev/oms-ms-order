package com.oms.msorder.model.response;

import com.oms.msorder.model.enumeration.OrderStatusType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponse {

    private Long id;
    private Long customerId;
    private Long productId;
    private String trackingId;
    private OrderStatusType orderStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
