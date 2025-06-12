package com.example.practiceaxa.controller;


import com.example.practiceaxa.record.PermissionRecord;
import com.example.practiceaxa.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public PermissionRecord create(@RequestBody PermissionRecord record) {
        return permissionService.create(record);
    }

    @GetMapping
    public List<PermissionRecord> getAll() {
        return permissionService.getAll();
    }
}
