package com.example.sb402learn1.learnAbstractAndInterface;

import org.junit.jupiter.api.Test;

class CreditCardTest {
  @Test
  void test1() {
    Payment creditCard = new CreditCard(100);
    creditCard.processPayment();
    ((Refundable) creditCard).processRefund(50);

    Payment paypal = new CreditCard(200);
    paypal.processPayment();

    Payment bankTransfer = new BankTransfer(500);
    bankTransfer.processPayment();
    ((Refundable) bankTransfer).processRefund(100);
  }
}
