package com.sparta.miniorder.product.service;

import com.sparta.miniorder.product.dto.request.RequestProduct;
import com.sparta.miniorder.product.dto.response.ResponseProduct;
import jakarta.validation.Valid;

import java.util.List;

public interface ProductService {
    ResponseProduct createProduct(@Valid RequestProduct request);

    ResponseProduct getProduct(Long id);

    List<ResponseProduct> getProducts();

    ResponseProduct updateProduct(Long id, @Valid RequestProduct request);

    void deleteProduct(Long id);
}
