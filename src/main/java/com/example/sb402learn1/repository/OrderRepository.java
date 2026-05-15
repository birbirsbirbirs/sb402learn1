package com.example.sb402learn1.repository;

import com.example.sb402learn1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {}
