package com.sparta.miniorder.order.controller;

import com.sparta.miniorder.order.dto.request.RequestProduct;
import com.sparta.miniorder.order.dto.response.ResponseProduct;
import com.sparta.miniorder.order.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<ResponseProduct> createProduct(@Valid @RequestBody RequestProduct request) {
        ResponseProduct response = productService.createProduct(request);
        return ResponseEntity.created(URI.create("/api/products/" + response.id())).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProduct> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponseProduct>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseProduct> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody RequestProduct request
    ) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<ResponseProduct>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(productService.getProducts());
    }
}
