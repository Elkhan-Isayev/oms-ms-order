package com.oms.msorder.mapper;

import com.oms.msorder.model.entity.OrderEntity;
import com.oms.msorder.model.request.CreateOrderRequest;
import com.oms.msorder.model.request.UpdateOrderRequest;
import com.oms.msorder.model.response.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    @Mapping(target = "orderStatus", constant = "CREATED")
    OrderEntity mapToOrderEntity(CreateOrderRequest createOrderRequest);

    OrderResponse mapToOrderResponse(OrderEntity orderEntity);

    List<OrderResponse> mapToOrderResponseList(List<OrderEntity> orderEntities);

    void mapUpdateRequestToOrderEntity(@MappingTarget OrderEntity orderEntity,
                                       UpdateOrderRequest updateOrderRequest);
}
