package com.example.practiceaxa.controller;


import com.example.practiceaxa.record.UserRecord;
import com.example.practiceaxa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserRecord create(@RequestBody UserRecord record) {
        return userService.createUser(record);
    }
    @PutMapping("/{userId}/assign-role/{roleId}")
    public UserRecord assignRole(@PathVariable Long userId, @PathVariable Long roleId) {
        return userService.assignRoleToUser(userId, roleId);
    }
    
    @GetMapping
    public List<UserRecord> getAll() {
        return userService.getAllUsers();
    }
}
