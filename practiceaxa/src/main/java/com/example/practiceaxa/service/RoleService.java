// filepath: d:\practiceaxa\src\main\java\com\example\practiceaxa\service\RoleService.java
package com.example.practiceaxa.service;

import com.example.practiceaxa.entity.Role;
import com.example.practiceaxa.entity.Permission;
import com.example.practiceaxa.record.RoleRecord;
import com.example.practiceaxa.repository.RoleRepository;
import com.example.practiceaxa.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository; // Inject PermissionRepository

    public RoleRecord createRole(RoleRecord record) {
        Role role = new Role();
        role.setRoleName(record.roleName());
        Role saved = roleRepository.save(role);
        return new RoleRecord(saved.getRoleId(), saved.getRoleName());
    }

    public RoleRecord applyPermission(Long roleId, Long permissionId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        role.getPermissions().add(permission); // Ensure Role entity has a permissions field
        Role updated = roleRepository.save(role);

        return new RoleRecord(updated.getRoleId(), updated.getRoleName());
    }

    public List<RoleRecord> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(r -> new RoleRecord(r.getRoleId(), r.getRoleName()))
                .toList();
    }
}