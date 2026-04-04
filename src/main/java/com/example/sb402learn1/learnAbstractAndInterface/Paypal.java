package com.example.sb402learn1.learnAbstractAndInterface;

public class Paypal extends Payment {

  Paypal(double amount) {
    super(amount);
  }

  @Override
  void processPayment() {
    System.out.println("processing paypal payment of $" + amount);
  }
}
