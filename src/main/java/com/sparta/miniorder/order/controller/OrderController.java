package com.sparta.miniorder.order.controller;

import com.sparta.miniorder.order.dto.request.RequestOrder;
import com.sparta.miniorder.order.dto.response.ResponseOrder;
import com.sparta.miniorder.order.service.OrderService;
import com.sparta.miniorder.product.entity.Product;
import com.sparta.miniorder.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ResponseOrder> createOrder(@Valid @RequestBody RequestOrder requestOrder) {
        ResponseOrder responseOrder = orderService.createOrder(requestOrder);
        return ResponseEntity.created(URI.create("/api/orders/" + responseOrder.orderId())).body(responseOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOrder> getOrder(@PathVariable Long id) {
        ResponseOrder responseOrder = orderService.getOrder(id);
        return ResponseEntity.ok(responseOrder);
    }



}
