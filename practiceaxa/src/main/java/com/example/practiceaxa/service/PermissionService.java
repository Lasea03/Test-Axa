package com.example.practiceaxa.service;

import com.example.practiceaxa.entity.Permission;
import com.example.practiceaxa.record.PermissionRecord;
import com.example.practiceaxa.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionRecord create(PermissionRecord record) {
        Permission permission = new Permission();
        permission.setPermissionType(record.permissionType());
        Permission saved = permissionRepository.save(permission);
        return new PermissionRecord(saved.getPermissionId(), saved.getPermissionType());
    }

    public List<PermissionRecord> getAll() {
        return permissionRepository.findAll().stream()
                .map(p -> new PermissionRecord(p.getPermissionId(), p.getPermissionType()))
                .toList();
    }
}
