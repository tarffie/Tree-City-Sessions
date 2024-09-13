package dev.tarffie.TreeCitySessions.user;

import java.time.LocalDateTime;

public record User(
    @id
    Integer id,
    String username,
    String password,
    LocalDateTime registeredOn
) {}
