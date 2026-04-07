package com.example.sb402learn1.learnGenerics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BaeldungGeneric {
  public <T> List<T> fromArrayToList(T[] a) {
    return Arrays.stream(a).collect(Collectors.toList());
  }

  public <T, G> List<G> fromArrayToListMultiple(T[] a, Function<T, G> mapperFunction) {
    return Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
  }
}
