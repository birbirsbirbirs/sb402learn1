package com.example.sb402learn1.handler;

import com.example.sb402learn1.entity.Product;
import com.example.sb402learn1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductHandler {
  private final ProductRepository productRepository;

  public Product updateProduct(Product product) {
    return productRepository.save(product);
  }

  public Product getProduct(int id) {
    return productRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("product not found"));
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }
}
