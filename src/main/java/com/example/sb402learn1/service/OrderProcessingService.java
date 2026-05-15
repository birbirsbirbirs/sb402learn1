package com.example.sb402learn1.service;

import com.example.sb402learn1.entity.Order;
import com.example.sb402learn1.entity.Product;
import com.example.sb402learn1.handler.OrderHandler;
import com.example.sb402learn1.handler.ProductHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderProcessingService {
  private final OrderHandler orderHandler;
  private final ProductHandler productHandler;

  public Order placeAnOrder(Order order) {
    //        get product from inventory

    Product product = productHandler.getProduct(order.getProductId());

    //        validate stock availability
    if (order.getQuantity() > product.getStockQuantity()) {
      throw new RuntimeException("insufficinet stock !");
    }

    //        update total price in order entity
    order.setTotalPrice(order.getQuantity() * product.getPrice());
    //        save order
    Order savedOrder = orderHandler.save(order);

    updateInventoryStock(order, product);
    return savedOrder;
  }

  private void updateInventoryStock(Order order, Product product) {
    //        update stock in inventory
    int avaiableStock = product.getStockQuantity() - order.getQuantity();
    product.setStockQuantity(avaiableStock);
    productHandler.updateProduct(product);
  }
}
