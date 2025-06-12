package com.example.practiceaxa.entity;
import com.example.practiceaxa.enumeration.PermissionType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PermissionType permissionType;
}
