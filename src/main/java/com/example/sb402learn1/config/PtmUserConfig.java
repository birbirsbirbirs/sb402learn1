package com.example.sb402learn1.config;

import com.example.sb402learn1.mode.PtmUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class PtmUserConfig {
    @Bean
    @Scope(WebApplicationContext.SCOPE_REQUEST)
    public PtmUser getPtmUser(){
        return new PtmUser();
    }
}
