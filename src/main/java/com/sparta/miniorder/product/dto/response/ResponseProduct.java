package com.sparta.miniorder.product.dto.response;

import com.sparta.miniorder.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

@Schema(description = "상품 응답 DTO")
public record ResponseProduct(
        @Schema(description = "상품 ID", example = "1")
        Long id,
        @Schema(description = "상품명", example = "아메리카노")
        String name,
        @Schema(description = "상품 가격", example = "4500")
        Integer price
) {

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

