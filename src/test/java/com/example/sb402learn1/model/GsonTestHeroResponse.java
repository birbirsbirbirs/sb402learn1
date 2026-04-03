package com.example.sb402learn1.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.sb402learn1.mode.Item;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.http.HttpStatus;

@JsonTest
public class GsonTestHeroResponse {
  @Autowired Gson gson;

  @Test
  void testHeroResponseSerialization() {
    MiniResponse miniResponse = MiniResponse.builder().power1("power1").power2("power1").build();
    HeroResponse heroResponse =
        HeroResponse.builder()
            .name(null)
            .status(HttpStatus.OK)
            .message(miniResponse.toString())
            .build();
    String writtenValueAsString = gson.toJson(heroResponse);
    System.out.println(writtenValueAsString);

    //    deserialize
    HeroResponse heroResponse1 = gson.fromJson(writtenValueAsString, HeroResponse.class);
    System.out.println(heroResponse1);
    assertAll(
        "test-deserialization",
        () -> assertEquals(heroResponse.getMessage(), miniResponse.toString()),
        () -> assertEquals(HttpStatus.OK, heroResponse1.getStatus()));
  }

  @Test
  void testFailed() {
    String jsonString =
        """
                {
                    "id": 1,
                    "itemName": "theItem",
                    "createdBy": 2
                }
                """;

    Item itemDeserialized = gson.fromJson(jsonString, Item.class);
    System.out.println(itemDeserialized);
  }
}
