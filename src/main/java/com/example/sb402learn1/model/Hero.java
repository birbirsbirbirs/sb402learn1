package com.example.sb402learn1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Hero {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column
    private UUID id;
    private String name;
    private String title;
    private LocalDateTime birthday;
    private String apple;
}
