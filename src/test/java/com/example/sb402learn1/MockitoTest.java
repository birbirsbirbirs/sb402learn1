package com.example.sb402learn1;

import com.example.sb402learn1.model.Hero;
import com.example.sb402learn1.repository.HeroRepositroy;
import com.example.sb402learn1.service.HeroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    @Mock
    private HeroRepositroy heroRepositroy;

    @InjectMocks
    private HeroService heroService;


    @Test
    void testHero(){
        List<Hero> heroList = List.of(Hero.builder()
                .id(UUID.randomUUID())
                .name("name100")
                .title("title100")
                .apple("apple100")
                .build(),
                Hero.builder()
                        .id(UUID.randomUUID())
                        .name("name200")
                        .title("title200")
                        .apple("apple200")
                        .build());
        when(heroRepositroy.findAll()).thenReturn(heroList);
        assertThat(heroService.getAllHero()).isEqualTo(heroList);
//        InOrder inOrder = inOrder(heroRepositroy);
//        inOrder.verify(heroRepositroy).findAll();
        verify(heroRepositroy).findAll();
    }

}
