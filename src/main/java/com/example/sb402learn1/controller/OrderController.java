package com.example.sb402learn1.controller;

import com.example.sb402learn1.entity.Order;
import com.example.sb402learn1.service.OrderProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
  private final OrderProcessingService orderProcessingService;

  @PostMapping
  public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
    Order ordered = orderProcessingService.placeAnOrder(order);
    return ResponseEntity.ok(ordered);
  }
}
