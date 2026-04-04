package com.example.sb402learn1.learnAbstractAndInterface;

public class CreditCard extends Payment implements Refundable {

  public CreditCard(double amount) {
    super(amount);
  }

  @Override
  public void processRefund(double amount) {
    System.out.println("processing credit card refund amount of $" + amount);
  }

  @Override
  void processPayment() {
    System.out.println("processing credit card payment of $" + amount);
  }
}
