package com.oms.msorder.controller;

import com.oms.msorder.exception.custom.BadRequestException;
import com.oms.msorder.model.request.CreateOrderRequest;
import com.oms.msorder.model.request.UpdateOrderRequest;
import com.oms.msorder.model.response.OrderResponse;
import com.oms.msorder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderResponse create(@RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createNewOrder(createOrderRequest);
    }

    @PutMapping("/{id}")
    public OrderResponse update(@PathVariable Long id,
                                @RequestBody UpdateOrderRequest updateOrderRequest) {
        if (ObjectUtils.isEmpty(updateOrderRequest) || ObjectUtils.isEmpty(id)) {
            throw new BadRequestException(String.format("controller.update body = %s", updateOrderRequest));
        }
        return orderService.update(id, updateOrderRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }

    @GetMapping
    public List<OrderResponse> getAll(@RequestParam(value="page", defaultValue="1") int page,
                                     @RequestParam(value="size", defaultValue="10") int size) {
        if (page <= 0 || size <= 0) {
            throw new BadRequestException(String.format("controller.getAll page = %s size = %s", page, size));
        }

        return orderService.getAll(page, size);
    }

    @GetMapping("/count")
    public Long getAllUsersCount() {
        return orderService.getAllOrdersCount();
    }

}
