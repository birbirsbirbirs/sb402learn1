package com.example.sb402learn1.testString;

import org.junit.jupiter.api.Test;

public class TestString {
  @Test
  void testStringFormatted() {
    String formattedString = "hello %s".formatted("this is awesome");
    System.out.println(formattedString);
  }
}
