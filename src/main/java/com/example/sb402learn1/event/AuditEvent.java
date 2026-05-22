package com.example.sb402learn1.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuditEvent<T> extends ApplicationEvent {
  private T data;

  public AuditEvent(T event) {
    super(event);
    this.data = event;
  }
}
