package com.bubble.bubble.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "apps")
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private long id;
    private String appName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_table_id")
    private User userTable;

    /////
    @JsonManagedReference
    @OneToMany(mappedBy = "app" ,cascade = CascadeType.ALL ,orphanRemoval = true)
    private Set<AppTable> appTable =new HashSet<>();
}