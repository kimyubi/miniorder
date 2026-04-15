package com.sparta.miniorder.order.dto.request;

import com.sparta.miniorder.order.entity.Order;
import com.sparta.miniorder.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "주문 요청 DTO")
public class RequestOrder {

    @Schema(description = "주문할 상품 ID", example = "1", minimum = "1")
    @NotNull(message = "{validation.order.product-id.not-null}")
    @Positive(message = "{validation.order.product-id.positive}")
    private Long productId;

    @Schema(description = "주문 수량", example = "2", minimum = "1")
    @NotNull(message = "{validation.order.quantity.not-null}")
    @Min(value = 1, message = "{validation.order.quantity.min}")
    private Integer quantity;

    public Order toEntity(Product product) {
        return new Order(product, quantity);
    }
}
