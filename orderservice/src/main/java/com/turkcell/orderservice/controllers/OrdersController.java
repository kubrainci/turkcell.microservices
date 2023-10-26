package com.turkcell.orderservice.controllers;

import com.turkcell.orderservice.dtos.requests.CreateOrderRequest;
import com.turkcell.orderservice.services.OrderService;
import com.turkcell.productservice.dtos.responses.ResponseForSubmitOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequestMapping("/api/v1/orders")
@RestController
@RequiredArgsConstructor

public class OrdersController {
    private final OrderService orderService;

    @PostMapping("/submit-order")
    public List<ResponseForSubmitOrder>submitOrder(@RequestBody List<CreateOrderRequest> request){
        return orderService.submitOrder(request);
    }
}
