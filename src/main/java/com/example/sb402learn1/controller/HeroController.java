package com.example.sb402learn1.controller;

import com.example.sb402learn1.mode.PtmUser;
import com.example.sb402learn1.mode.SukUser;
import com.example.sb402learn1.model.Hero;
import com.example.sb402learn1.service.HeroService;
import io.micrometer.tracing.Tracer;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/hero")
public class HeroController {

  @Nullable private final HeroService heroService;
  private final JsonMapper jsonMapper;
  private final Tracer tracer;
  private final ObjectProvider<PtmUser> ptmUser;
  private final SukUser sukUser;

  @GetMapping("/hero")
  public @Nullable Hero getHero() {
    ptmUser.getObject().setName("hero100");
    sukUser.setUsername("sukUser100");
    log.info("printing ptmuser: {}", ptmUser.getObject());
    log.info("printing sukUser: {}", sukUser.getUsername());
    if (heroService != null && heroService.getHero() != null) {
      return heroService.getHero();
    } else {
      return null;
    }
  }

  @PostMapping
  public @Nullable Hero addHero(@RequestBody Hero hero) {
    if (heroService != null) {
      return heroService.save(hero);
    } else {
      return null;
    }
  }

  @PostMapping("/save")
  public @Nullable Hero saveHero(@RequestBody Hero hero) {
    if (heroService != null) {
      return heroService.saveHero(hero);
    } else {
      return null;
    }
  }

  @GetMapping("/all-hero")
  public @Nullable List<Hero> getAllHero() {
    if (heroService != null) {
      return heroService.getAllHero();
    } else {
      return null;
    }
  }

  @GetMapping("/laxmi")
  public @Nullable Hero laxmiCreateHero() {
    Hero hero =
        Hero.builder()
            .id(UUID.randomUUID())
            .name("name100")
            .title("title100")
            .apple("apple100")
            .build();
    if (heroService != null) {
      return heroService.builFromLaxmiService(hero);
    } else {
      return null;
    }
  }

  @GetMapping("/nullendpoint/{number}")
  public @Nullable String nullendpoint(@PathVariable Integer number) {
    if (heroService != null) {
      @Nullable Hero result = heroService.returnNull(number);
      if (result != null) return result.toString();
    }
    return null;
  }
}
