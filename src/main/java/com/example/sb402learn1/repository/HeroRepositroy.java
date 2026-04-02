package com.example.sb402learn1.repository;


import com.example.sb402learn1.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HeroRepositroy extends JpaRepository<Hero, UUID> {
}
