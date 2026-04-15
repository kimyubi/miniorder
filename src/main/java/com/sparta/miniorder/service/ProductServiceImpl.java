package com.sparta.miniorder.service;

import com.sparta.miniorder.dto.request.RequestProduct;
import com.sparta.miniorder.dto.response.ResponseProduct;
import com.sparta.miniorder.entity.Product;
import com.sparta.miniorder.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public ResponseProduct createProduct(RequestProduct request) {
        Product savedProduct = productRepository.save(request.toEntity());
        return ResponseProduct.from(savedProduct);
    }

    @Override
    public ResponseProduct getProduct(Long id) {
        return null;
    }

    @Override
    public List<ResponseProduct> getProducts() {
        return List.of();
    }

    @Override
    public ResponseProduct updateProduct(Long id, RequestProduct request) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        // continue
    }
}
