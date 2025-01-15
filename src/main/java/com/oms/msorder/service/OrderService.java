package com.oms.msorder.service;

import com.oms.msorder.exception.custom.NotFoundException;
import com.oms.msorder.mapper.OrderMapper;
import com.oms.msorder.model.entity.OrderEntity;
import com.oms.msorder.model.request.CreateOrderRequest;
import com.oms.msorder.model.request.UpdateOrderRequest;
import com.oms.msorder.model.response.OrderResponse;
import com.oms.msorder.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderResponse> getAll(int page, int size) {
        List<OrderEntity> orders = orderRepository.findAll(PageRequest.of(page - 1, size))
                .stream()
                .collect(Collectors.toList());

        if (orders.isEmpty()) {
            throw new NotFoundException(String.format("service.getAll page = %s and size = %s", page, size));
        }

        return orderMapper.mapToOrderResponseList(orders);
    }

    public Long getAllOrdersCount() {
        return orderRepository.count();
    }

    public OrderResponse createNewOrder(CreateOrderRequest createOrderRequest) {
        var orderEntity = orderMapper.mapToOrderEntity(createOrderRequest);

        var createdOrder = orderRepository.save(orderEntity);

        return orderMapper.mapToOrderResponse(createdOrder);
    }

    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new NotFoundException(String.format("service.delete id = %s", id));
        }

        orderRepository.deleteById(id);
    }

    public OrderResponse update(Long id, UpdateOrderRequest updateOrderRequest) {

        var order = orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("service.update id = %s", id)));

        orderMapper.mapUpdateRequestToOrderEntity(order, updateOrderRequest);

        return orderMapper.mapToOrderResponse(orderRepository.save(order));
    }

}
