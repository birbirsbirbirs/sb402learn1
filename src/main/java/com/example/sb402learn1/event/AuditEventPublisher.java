package com.example.sb402learn1.event;

import com.example.sb402learn1.entity.LogData;
import jakarta.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuditEventPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;

  public void publishEvent(String message) {
    Map<String, String> dataMap = new LinkedHashMap<>();
    HttpServletRequest request =
        ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
            .getRequest();
    dataMap.put("host", request.getHeader("host"));
    dataMap.put("user-agent", request.getHeader("user-Agent"));
    dataMap.put("message", message);
    applicationEventPublisher.publishEvent(
        new AuditEvent<LogData>(LogData.builder().data(dataMap).build()));
  }
}
