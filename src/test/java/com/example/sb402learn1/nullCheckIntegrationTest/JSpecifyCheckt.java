package com.example.sb402learn1.nullCheckIntegrationTest;

import com.example.sb402learn1.Sb402learn1Application;
import com.example.sb402learn1.service.LaxmiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;

@ExtendWith(MockitoExtension.class)
public class JSpecifyCheckt {

  @InjectMocks private LaxmiService laxmiService;

  @Test
  void testNull() {
    var app = new SpringApplication(Sb402learn1Application.class);
    var webApplicationType = app.getWebApplicationType();
    IO.println(webApplicationType.toString());
  }

  @Test
  void testNull2() {
    var app = new SpringApplication(Sb402learn1Application.class);
    app.setBeanNameGenerator(null);
  }

  @Test
  void testNullInLaxmiService() {
    laxmiService.createHero(null);
  }
}
