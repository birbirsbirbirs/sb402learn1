package com.example.sb402learn1.model;

import com.example.sb402learn1.mode.Item;
import com.example.sb402learn1.mode.User;
import org.springframework.boot.jackson.JacksonComponent;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;

@JacksonComponent
public class ItemJackson {

  public static class ItemDeserializer extends ValueDeserializer<Item> {
    @Override
    public Item deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
      JsonNode jsonNode = p.readValueAsTree();
      int createdBy = jsonNode.get("createdBy").asInt();
      int id = jsonNode.get("id").asInt();
      String itemName = jsonNode.get("itemName").asString();
      return Item.builder()
          .id(id)
          .itemName(itemName)
          .owner(User.builder().id(createdBy).build())
          .build();
    }
  }
}
