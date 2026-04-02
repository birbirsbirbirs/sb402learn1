package com.example.sb402learn1;

import com.example.sb402learn1.model.Hero;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import tools.jackson.databind.json.JsonMapper;

@JsonTest
@Slf4j
@ExtendWith(MockitoExtension.class)
class Sb402learn1ApplicationTests {

  @Autowired private JsonMapper jsonMapper;

  @Test
  void testSerialization() {
    Hero hero =
        new Hero(
            UUID.randomUUID(), "name100", "software engineer", LocalDateTime.now(), "apple100");
    log.info("hero: {}", hero);
    String serializehero = jsonMapper.writeValueAsString(hero);
    log.info("serializehero: {}", serializehero);
  }

  @Test
  void testDeserialization() {

    String heroString =
        """
                {
                "name":"hero100",
                "title":"senior software engineer",
                "birthday":"2025-11-06T06:00:00"
                }
                """;

    Hero deSerializedHero = jsonMapper.readValue(heroString, Hero.class);
    log.info("deSerializedHero: {}", deSerializedHero);
  }
}
