package com.example.sb402learn1.service;

import com.example.sb402learn1.model.Hero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LaxmiService {
  public Hero createHero(Hero hero) {
    return hero;
  }
}
