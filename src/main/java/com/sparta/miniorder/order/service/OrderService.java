package com.sparta.miniorder.order.service;

import com.sparta.miniorder.order.dto.request.RequestOrder;
import com.sparta.miniorder.order.dto.response.ResponseOrder;

public interface OrderService {
    ResponseOrder createOrder(RequestOrder request);
}
