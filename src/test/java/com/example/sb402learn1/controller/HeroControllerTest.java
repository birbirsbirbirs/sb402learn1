package com.example.sb402learn1.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.sb402learn1.model.Hero;
import com.example.sb402learn1.service.HeroService;
import io.micrometer.tracing.Tracer;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {HeroControllerTest.class, TestController.class})
class HeroControllerTest {

  @MockitoBean private HeroService heroService;

  @MockitoBean private Tracer tracer;

  @Autowired private MockMvc mockMvc;

  @Test
  void getHero() throws Exception {
    Hero hero =
        Hero.builder()
            .id(UUID.randomUUID())
            .name("name100")
            .title("title100")
            .birthday(LocalDateTime.now())
            .apple("apple100")
            .build();
    when(heroService.getHero()).thenReturn(hero);
    mockMvc.perform(get("/test/hero")).andExpect(status().isOk());
  }

  @Test
  void getTestController() throws Exception {
    Hero hero =
        Hero.builder()
            .id(UUID.randomUUID())
            .name("name100")
            .title("title100")
            .birthday(LocalDateTime.now())
            .apple("apple100")
            .build();
    when(heroService.getHero()).thenReturn(hero);
    mockMvc.perform(get("/test/hero")).andExpect(status().isOk());
  }
}
