package com.sparta.miniorder.order.dto.response;

import java.util.Objects;

import com.sparta.miniorder.order.entity.Order;
import com.sparta.miniorder.product.entity.Product;

public record ResponseOrder(
        Long orderId,
        Long productId,
        String productName,
        Integer productPrice
) {

    private static final String NULL_ORDER_MESSAGE = "주문 정보는 null이 될 수 없습니다.";
    private static final String NULL_PRODUCT_MESSAGE = "상품 정보는 null이 될 수 없습니다.";

    public static ResponseOrder from(Order order) {
        Objects.requireNonNull(order, NULL_ORDER_MESSAGE);

        Product product = Objects.requireNonNull(order.getProduct(), NULL_PRODUCT_MESSAGE);

        return new ResponseOrder(
                order.getId(),
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
