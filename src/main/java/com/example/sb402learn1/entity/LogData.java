package com.example.sb402learn1.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class LogData {
  private Map<String, String> data;
}
