package com.example.sb402learn1.handler;

import com.example.sb402learn1.entity.Order;
import com.example.sb402learn1.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderHandler {
  private final OrderRepository orderRepository;

  public Order save(Order order) {
    return orderRepository.save(order);
  }
}
