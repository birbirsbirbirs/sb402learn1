package com.example.sb402learn1;


import org.junit.jupiter.api.Test;

class Sb402learn1ApplicationTest {
 @Test
 void test1(){
     boolean isRaining=true;
     IO.println("bring an umbrella");
     if(20>18){
         IO.println("20 is greater than 10");
     }
     method1(10,10);
 }

 void method1(int firstNumber,int secondNumber){
     if(firstNumber==secondNumber){
         IO.println("first number is equal to the second number");
     }
 }
}
