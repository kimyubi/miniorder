package com.sparta.miniorder.product.service;

import com.sparta.miniorder.global.exception.ProductNotFoundException;
import com.sparta.miniorder.product.dto.request.RequestProduct;
import com.sparta.miniorder.product.dto.response.ResponseProduct;
import com.sparta.miniorder.product.entity.Product;
import com.sparta.miniorder.product.repository.ProductRepository;
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
    @Transactional
    public ResponseProduct createProduct(RequestProduct request) {
        Product savedProduct = productRepository.save(request.toEntity());
        return ResponseProduct.from(savedProduct);
    }

    @Override
    public ResponseProduct getProduct(Long id) {
        return ResponseProduct.from(findProductById(id));
    }

    @Override
    public List<ResponseProduct> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(ResponseProduct::from)
                .toList();
    }

    @Override
    @Transactional
    public ResponseProduct updateProduct(Long id, RequestProduct request) {
        Product product = findProductById(id);
        product.update(request.getName(), request.getPrice());
        return ResponseProduct.from(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.delete(findProductById(id));
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }
}
