package com.example.practiceaxa.controller;


import com.example.practiceaxa.record.RoleRecord;
import com.example.practiceaxa.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public RoleRecord create(@RequestBody RoleRecord record) {
        return roleService.createRole(record);
    }
    @PutMapping("/{roleId}/apply-permission/{permissionId}")
    public RoleRecord applyPermission(@PathVariable Long roleId, @PathVariable Long permissionId) {
        return roleService.applyPermission(roleId, permissionId);
    }
    
    @GetMapping
    public List<RoleRecord> getAll() {
        return roleService.getAllRoles();
    }
}
