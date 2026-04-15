package com.sparta.miniorder.order.service;

import com.sparta.miniorder.global.exception.ProductNotFoundException;
import com.sparta.miniorder.order.dto.request.RequestOrder;
import com.sparta.miniorder.order.dto.response.ResponseOrder;
import com.sparta.miniorder.order.entity.Order;
import com.sparta.miniorder.order.repository.OrderRepository;
import com.sparta.miniorder.product.entity.Product;
import com.sparta.miniorder.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public ResponseOrder createOrder(RequestOrder requestOrder) {
        Product product = findProductById(requestOrder.getProductId());
        Order savedOrder = orderRepository.save(requestOrder.toEntity(product));
        return ResponseOrder.from(savedOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseOrder getOrder(Long id) {
        return ResponseOrder.from(findOrderById(id));
    }

    private Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }
}
