package com.example.sb402learn1.event;

import com.example.sb402learn1.entity.LogData;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuditEventHandler {
  private final JsonMapper jsonMapper;

  @SneakyThrows
  @EventListener
  @Async
  public void handleEvent(AuditEvent<LogData> auditEvent) {
    log.info(
        "{}", jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(auditEvent.getData()));
  }
}
