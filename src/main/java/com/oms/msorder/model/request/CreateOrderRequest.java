package com.oms.msorder.model.request;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private Long customerId;
    private Long itemId;

}
