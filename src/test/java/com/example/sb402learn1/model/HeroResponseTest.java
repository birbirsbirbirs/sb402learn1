package com.example.sb402learn1.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.http.HttpStatus;
import tools.jackson.databind.json.JsonMapper;

@JsonTest
class HeroResponseTest {

  @Autowired JsonMapper jsonMapper;

  @Test
  void testHeroResponseSerialization() {
    MiniResponse miniResponse = MiniResponse.builder().power1("power1").power2("power1").build();
    HeroResponse heroResponse =
        HeroResponse.builder()
            .name(null)
            .status(HttpStatus.OK)
            .message(miniResponse.toString())
            .build();
    String writtenValueAsString = jsonMapper.writeValueAsString(heroResponse);
    System.out.println(writtenValueAsString);

    //    deserialize
    HeroResponse heroResponse1 = jsonMapper.readValue(writtenValueAsString, HeroResponse.class);
    System.out.println(heroResponse1);
    assertAll(
        "test-deserialization",
        () -> assertEquals(heroResponse.getMessage(), miniResponse.toString()),
        () -> assertEquals(HttpStatus.OK, heroResponse1.getStatus()));
  }
}
