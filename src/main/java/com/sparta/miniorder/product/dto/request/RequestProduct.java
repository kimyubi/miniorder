package com.sparta.miniorder.product.dto.request;

import com.sparta.miniorder.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "상품 요청 DTO")
public class RequestProduct {

    @Schema(description = "상품명", example = "아메리카노")
    @NotBlank(message = "{validation.product.name.not-blank}")
    private String name;

    @Schema(description = "상품 가격", example = "4500", minimum = "0")
    @NotNull(message = "{validation.product.price.not-null}")
    @Min(value = 0, message = "{validation.product.price.min}")
    private Integer price;

    public Product toEntity() {
        return new Product(name, price);
    }
}
