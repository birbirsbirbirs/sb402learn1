package com.example.sb402learn1.mode;

import com.example.sb402learn1.model.ItemJackson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.annotation.JsonDeserialize;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonDeserialize(using = ItemJackson.ItemDeserializer.class)
public class Item {
  public int id;
  public String itemName;
  public User owner;
}
