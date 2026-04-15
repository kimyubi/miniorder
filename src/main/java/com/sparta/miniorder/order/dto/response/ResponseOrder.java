package com.sparta.miniorder.order.dto.response;

import java.util.Objects;

import com.sparta.miniorder.order.entity.Order;
import com.sparta.miniorder.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "주문 응답 DTO")
public record ResponseOrder(
        @Schema(description = "주문 ID", example = "1")
        Long orderId,
        @Schema(description = "주문 수량", example = "2")
        Integer quantity,
        @Schema(description = "상품 ID", example = "1")
        Long productId,
        @Schema(description = "상품명", example = "아메리카노")
        String productName,
        @Schema(description = "상품 가격", example = "4500")
        Integer productPrice
) {

    private static final String NULL_ORDER_MESSAGE = "주문 정보는 null이 될 수 없습니다.";
    private static final String NULL_PRODUCT_MESSAGE = "상품 정보는 null이 될 수 없습니다.";

    public static ResponseOrder from(Order order) {
        Objects.requireNonNull(order, NULL_ORDER_MESSAGE);

        Product product = Objects.requireNonNull(order.getProduct(), NULL_PRODUCT_MESSAGE);

        return new ResponseOrder(
                order.getId(),
                order.getQuantity(),
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
