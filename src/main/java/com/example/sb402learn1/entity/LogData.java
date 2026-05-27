package com.example.sb402learn1.entity;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogData {
  private Map<String, String> data;
}
