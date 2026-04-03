package com.example.sb402learn1.model;

import com.example.sb402learn1.mode.Item;
import com.example.sb402learn1.mode.User;
import org.springframework.boot.jackson.JacksonComponent;
import org.springframework.boot.jackson.ObjectValueDeserializer;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;

@JacksonComponent
public class ItemJackson {

  public static class ItemDeserializer extends ObjectValueDeserializer<Item> {

    @Override
    protected Item deserializeObject(
        JsonParser jsonParser, DeserializationContext context, JsonNode tree) {
      Integer createdBy = nullSafeValue(tree.get("createdBy"), Integer.class);
      Integer id = nullSafeValue(tree.get("id"), Integer.class);
      String itemName = nullSafeValue(tree.get("itemName"), String.class);
      createdBy = createdBy == null ? 0 : createdBy;
      return Item.builder()
          .id(id)
          .itemName(itemName)
          .owner(User.builder().id(createdBy).build())
          .build();
    }
  }
}
