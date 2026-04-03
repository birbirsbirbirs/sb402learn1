package com.example.sb402learn1.service;

import com.example.sb402learn1.mode.PtmUser;
import com.example.sb402learn1.model.Hero;
import com.example.sb402learn1.repository.HeroRepositroy;
import jakarta.inject.Provider;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeroService {

  private final JsonMapper jsonMapper;
  private final HeroRepositroy heroRepositroy;
  private final Provider<PtmUser> ptmUser;
  private final LaxmiService laxmiService;

  public Hero getHero() {
    Hero hero = new Hero();
    log.info("printing ptmuser: {}", ptmUser.get().toString());
    log.info("returning hero {}", hero);
    return hero;
  }

  public Hero save(Hero hero) {
    log.info("saving hero {}", hero);
    return hero;
  }

  public Hero saveHero(Hero hero) {
    Hero savedHero = heroRepositroy.save(hero);
    log.info("saved hero {}", savedHero);
    return savedHero;
  }

  public List<Hero> getAllHero() {
    log.info("returning all heroes");
    return heroRepositroy.findAll();
  }

  public Hero builFromLaxmiService(Hero hero) {
    Hero hero1 = laxmiService.createHero(hero);
    return hero1;
  }
}
