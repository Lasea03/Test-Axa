package com.example.practiceaxa.repository;

import com.example.practiceaxa.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
