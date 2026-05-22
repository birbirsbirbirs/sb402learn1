package com.example.sb402learn1.controller;

import com.example.sb402learn1.entity.User;
import com.example.sb402learn1.event.AuditEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
  private final AuditEventPublisher auditEventPublisher;

  @PostMapping
  public String register(@RequestBody User user) {
    log.info("publishing the event!!");
    auditEventPublisher.publishEvent("User saved successfully!! with " + user.getUsername());
    return "User saved successfully!!";
  }
}
