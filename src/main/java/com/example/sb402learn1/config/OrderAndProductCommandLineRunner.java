package com.example.sb402learn1.config;

import com.example.sb402learn1.entity.Product;
import com.example.sb402learn1.handler.OrderHandler;
import com.example.sb402learn1.handler.ProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.DeserializationFeature;

@RequiredArgsConstructor
@Configuration
public class OrderAndProductCommandLineRunner implements CommandLineRunner {
  private final OrderHandler orderHandler;
  private final ProductHandler productHandler;

  @Override
  public void run(String... args) throws Exception {
    Product product = Product.builder().name("pen").price(10).stockQuantity(10).build();
    productHandler.save(product);
  }

  @Bean
  public JsonMapperBuilderCustomizer customizer() {
    return builder -> builder.disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
  }
}
