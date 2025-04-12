package com.sprk.spring_security_demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.TreeSet;

@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String username;

    private String password;

    private String email;

    // ROLES
    @ManyToMany(fetch = FetchType.EAGER, cascade =  {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(name = "user_info_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleModel> roles = new TreeSet<>();

}
