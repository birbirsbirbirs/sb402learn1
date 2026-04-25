package com.example.sb402learn1.learnGenerics;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestGenerics {
  @InjectMocks private BaeldungGeneric baeldungGeneric;

  @Test
  void bauldung() {
    List<Integer> list = new LinkedList<>();
    list.add(new Integer(1));
    Integer nextInteger = list.iterator().next();
    System.out.println(nextInteger);
  }

  @Test
  void testBaeldunGeneric() {
    Integer[] integerArray = {1, 2, 3, 5, 10};
    List<Integer> integersList = baeldungGeneric.fromArrayToList(integerArray);
    integersList.parallelStream().forEach(p -> System.out.println(p));
  }

  @Test
  void TestFromArrayToListMultiple() {
    Integer[] integerArray = {1, 2, 3, 5, 10};
    List<String> stringsList =
        baeldungGeneric.fromArrayToListMultiple(integerArray, Object::toString);
    assertThat(stringsList).containsExactlyInAnyOrder("1", "2", "3", "5", "10");
  }

  @Test
  void testMyGenerics() {
    MyGenericClass generic = new MyGenericClass();
    List<Integer> integers = List.of(1, 2, 3, 4);
    List<Integer> collect = integers.parallelStream().collect(Collectors.toList());
    generic.add(1, collect);
  }

  @Test
  void testMyGenericsAddAndReturn() {
    List<Integer> integerList = List.of(1, 2, 3, 4, 5);

    List<Integer> listInteger = new ArrayList<>(integerList);
    listInteger.add(2);
  }
}
