package com.example.practiceaxa.record;

public record UserRecord(
    Long id,
    String username,
    String password,
    Long roleId
) {}
