package com.example.practiceaxa.record;

import com.example.practiceaxa.enumeration.PermissionType;

public record PermissionRecord(
    Long id,
    PermissionType permissionType
) {}
