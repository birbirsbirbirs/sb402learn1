package com.example.sb402learn1.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.example.sb402learn1.model.Hero;
import com.example.sb402learn1.repository.HeroRepositroy;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArgumentCaptureTest {

  @Mock private HeroRepositroy heroRepositroy;

  @Mock private LaxmiService laxmiService;

  @InjectMocks private HeroService heroService;

  @Captor ArgumentCaptor<Hero> heroCaptor;

  @Test
  void checkHeroCreated() {
    Hero hero =
        Hero.builder()
            .id(UUID.randomUUID())
            .name("name100")
            .title("title100")
            .apple("apple100")
            .build();

    heroService.saveHero(hero);
    verify(heroRepositroy).save(heroCaptor.capture());
    Hero heroCapture = heroCaptor.getValue();

    assertAll(
        "assert hero",
        () -> assertEquals(hero.getId(), heroCapture.getId()),
        () -> assertEquals(hero.getName(), heroCapture.getName()),
        () -> assertEquals(hero.getApple(), heroCapture.getApple()));
  }

  @Test
  void checkHeroCreatedLaxmi() {
    Hero hero =
        Hero.builder()
            .id(UUID.randomUUID())
            .name("name100")
            .title("title100")
            .apple("apple200")
            .build();

    heroService.builFromLaxmiService(hero);
    verify(laxmiService).createHero(heroCaptor.capture());
    Hero heroCapture = heroCaptor.getValue();

    assertAll(
        "assert hero",
        () -> assertEquals(hero.getId(), heroCapture.getId()),
        () -> assertEquals(hero.getName(), heroCapture.getName()),
        () -> assertEquals(hero.getApple(), heroCapture.getApple()));
  }
}
