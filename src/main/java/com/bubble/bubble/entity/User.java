package com.bubble.bubble.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "user_id")
    private long id;
    private String userName;
    private String email;
    private String password;
    @OneToMany(mappedBy = "userTable" ,cascade = CascadeType.ALL ,orphanRemoval = true)
    private Set<App> app =new HashSet<>();
}
