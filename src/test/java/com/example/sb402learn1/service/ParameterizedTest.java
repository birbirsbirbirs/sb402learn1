package com.example.sb402learn1.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ParameterizedTest {
  @InjectMocks private LaxmiService laxmiService;

  @org.junit.jupiter.params.ParameterizedTest
  @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
  void testOdd(int number) {
    assertTrue(laxmiService.isOdd(number));
  }
}
