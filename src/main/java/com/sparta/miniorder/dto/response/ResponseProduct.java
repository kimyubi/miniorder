package com.sparta.miniorder.dto.response;

import com.sparta.miniorder.entity.Product;

import java.util.Objects;

public record ResponseProduct(Long id, String name, Integer price) {

    private static final String NULL_PRODUCT_MESSAGE = "상품 정보는 null이 될 수 없습니다.";

    public static ResponseProduct from(Product product) {
        Objects.requireNonNull(product, NULL_PRODUCT_MESSAGE);

        return new ResponseProduct(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}

