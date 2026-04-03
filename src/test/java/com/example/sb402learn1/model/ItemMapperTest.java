package com.example.sb402learn1.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.sb402learn1.mode.Item;
import com.example.sb402learn1.mode.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import tools.jackson.databind.json.JsonMapper;

@JsonTest
public class ItemMapperTest {
  @Autowired JsonMapper jsonMapper;

  @Test
  void serilizationDeserialization() {
    User username100 = User.builder().id(100).name("username100").build();
    Item itemname200 = Item.builder().id(200).itemName("itemname200").owner(username100).build();

    String itemStringJson = jsonMapper.writeValueAsString(itemname200);
    System.out.println(itemStringJson);

    Item itemDeserialized = jsonMapper.readValue(itemStringJson, Item.class);
    assertAll(
        "test-deserialized-item",
        () -> assertEquals(itemname200.getId(), itemDeserialized.getId()));
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

    Item itemDeserialized = jsonMapper.readValue(jsonString, Item.class);
    System.out.println(itemDeserialized);
  }
}
