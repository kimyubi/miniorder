package com.sparta.miniorder.order.dto.request;

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
}
