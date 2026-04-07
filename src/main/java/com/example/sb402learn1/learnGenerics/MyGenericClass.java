package com.example.sb402learn1.learnGenerics;

import java.util.List;

public class MyGenericClass {
  public <T> void add(T element, List<T> list) {
    list.add(element);
  }

  public <T> List<T> addAndReturn(T element, List<T> list) {
    list.add(element);
    return list;
  }

}
