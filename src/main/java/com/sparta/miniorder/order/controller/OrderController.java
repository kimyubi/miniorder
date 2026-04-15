package com.sparta.miniorder.order.controller;

import com.sparta.miniorder.order.dto.request.RequestOrder;
import com.sparta.miniorder.order.dto.response.ResponseOrder;
import com.sparta.miniorder.order.service.OrderService;
import com.sparta.miniorder.product.entity.Product;
import com.sparta.miniorder.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseOrder> createOrder(@Valid @RequestBody RequestOrder requestOrder) {
        ResponseOrder responseOrder = orderService.createOrder(requestOrder);
        return ResponseEntity.created(URI.create("/api/orders/" + responseOrder.orderId())).body(responseOrder);
    }



}
