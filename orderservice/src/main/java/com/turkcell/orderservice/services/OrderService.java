package com.turkcell.orderservice.services;

import com.turkcell.orderservice.dtos.requests.CreateOrderRequest;
import com.turkcell.productservice.dtos.responses.ResponseForSubmitOrder;


import java.util.List;

public interface OrderService  {
    List<ResponseForSubmitOrder> submitOrder( List<CreateOrderRequest> requests);
}
