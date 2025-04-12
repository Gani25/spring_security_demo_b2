package com.sprk.spring_security_demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<UserInfo> users;
}
