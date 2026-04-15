package com.sparta.miniorder.order.dto.request;

import com.sparta.miniorder.order.entity.Order;
import com.sparta.miniorder.product.entity.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestOrder {

    @NotNull(message = "{validation.order.product-id.not-null}")
    @Positive(message = "{validation.order.product-id.positive}")
    private Long productId;

    @NotNull(message = "{validation.order.quantity.not-null}")
    @Min(value = 1, message = "{validation.order.quantity.min}")
    private Integer quantity;

    public Order toEntity(Product product) {
        return new Order(product, quantity);
    }
}
