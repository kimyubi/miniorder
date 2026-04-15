package com.sparta.miniorder.order.dto.request;

import com.sparta.miniorder.order.entity.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestProduct {

    @NotBlank(message = "{validation.product.name.not-blank}")
    private String name;

    @NotNull(message = "{validation.product.price.not-null}")
    @Min(value = 0, message = "{validation.product.price.min}")
    private Integer price;

    public Product toEntity() {
        return new Product(name, price);
    }
}
