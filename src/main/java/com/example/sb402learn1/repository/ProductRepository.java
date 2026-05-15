package com.example.sb402learn1.repository;

import com.example.sb402learn1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
