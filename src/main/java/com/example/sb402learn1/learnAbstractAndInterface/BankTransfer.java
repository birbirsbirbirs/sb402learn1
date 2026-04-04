package com.example.sb402learn1.learnAbstractAndInterface;

public class BankTransfer extends Payment implements Refundable {
  public BankTransfer(double amount) {
    super(amount);
  }

  @Override
  void processPayment() {
    System.out.println("processing bank payment of $" + amount);
  }

  @Override
  public void processRefund(double amount) {
    System.out.println("refunding amount of $" + amount);
  }
}
