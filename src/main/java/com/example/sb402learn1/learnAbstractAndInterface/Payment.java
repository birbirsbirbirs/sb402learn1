package com.example.sb402learn1.learnAbstractAndInterface;

public abstract class Payment {
  double amount;

  Payment(double amount) {
    this.amount = amount;
  }

  abstract void processPayment();

  void showAmount() {
    System.out.println("processing payment of $" + amount);
  }
}
