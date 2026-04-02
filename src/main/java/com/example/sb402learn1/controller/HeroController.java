package com.example.sb402learn1.controller;

import com.example.sb402learn1.mode.PtmUser;
import com.example.sb402learn1.model.Hero;
import com.example.sb402learn1.service.HeroService;
import io.micrometer.tracing.Tracer;
import jakarta.inject.Provider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/hero")
public class HeroController {

    private final HeroService heroService;
    private final JsonMapper jsonMapper;
    private final Tracer tracer;
    private final Provider<PtmUser> ptmUser;

    @GetMapping("/hero")
    public Hero getHero() {
        ptmUser.get().setName("hero100");
        log.info("printing ptmuser: {}",ptmUser.get().toString());
        return heroService.getHero();
    }

    @PostMapping
    public Hero addHero(@RequestBody Hero hero) {
        return heroService.save(hero);
    }

    @PostMapping("/save")
    public Hero saveHero(@RequestBody Hero hero) {
        return heroService.saveHero(hero);
    }

    @GetMapping("/all-hero")
    public List<Hero> getAllHero() {
        return heroService.getAllHero();
    }

}
