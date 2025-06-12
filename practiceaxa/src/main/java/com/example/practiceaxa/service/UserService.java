package com.example.practiceaxa.service;

import com.example.practiceaxa.entity.Role;
import com.example.practiceaxa.entity.User;
import com.example.practiceaxa.record.UserRecord;
import com.example.practiceaxa.repository.RoleRepository;
import com.example.practiceaxa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserRecord createUser(UserRecord record) {
        Role role = roleRepository.findById(record.roleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setUsername(record.username());
        user.setPassword(record.password()); // bisa hash nanti
        user.setRole(role);

        User saved = userRepository.save(user);
        return new UserRecord(saved.getUserId(), saved.getUsername(), saved.getPassword(), saved.getRole().getRoleId());
    }
    public UserRecord assignRoleToUser(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    
        user.setRole(role);
        User updated = userRepository.save(user);
    
        return new UserRecord(updated.getUserId(), updated.getUsername(), updated.getPassword(), updated.getRole().getRoleId());
    }
    
    public List<UserRecord> getAllUsers() {
        return userRepository.findAll().stream()
                .map(u -> new UserRecord(u.getUserId(), u.getUsername(), u.getPassword(), u.getRole().getRoleId()))
                .toList();
    }
}
