package com.sparta.miniorder.order.repository;

import com.sparta.miniorder.order.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
