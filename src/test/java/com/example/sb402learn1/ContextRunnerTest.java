package com.example.sb402learn1;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.sb402learn1.condition.PtmCondition;
import com.example.sb402learn1.config.PtmUserConfig;
import com.example.sb402learn1.mode.BimalaUser;
import com.example.sb402learn1.mode.PtmUser;
import com.example.sb402learn1.mode.SukUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ContextRunnerTest {
  private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

  private final WebApplicationContextRunner webApplicationContextRunner =
      new WebApplicationContextRunner();

  @Test
  void contextRunnerTestSukUserBean() {
    this.contextRunner
        .withUserConfiguration(PtmCondition.class, PtmUserConfig.class)
        .run(
            context -> {
              SukUser sukUser = context.getBean(SukUser.class);
              assertThat(sukUser).isNotNull();
            });
  }

  @Test
  void contextRunnerTestPtmUserBean() {
    this.webApplicationContextRunner
        .withUserConfiguration(PtmUserConfig.class)
        .run(
            context -> {
              MockHttpServletRequest request = new MockHttpServletRequest();
              RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

              PtmUser ptmUser = context.getBean(PtmUser.class);
              assertThat(ptmUser).isNotNull();
            });
  }

  @Test
  void contextRunnerTestBimlaUser() {
    this.contextRunner
        .withPropertyValues("btm.user.enable=true")
        .withUserConfiguration(PtmUserConfig.class)
        .run(
            context -> {
              BimalaUser bimalaUser = context.getBean(BimalaUser.class);
              assertThat(bimalaUser).isNotNull();
            });
  }
}
