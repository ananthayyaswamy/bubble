package com.bubble.bubble.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "apps")
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appId;
    private String appName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_table_id")
    private User userTable;
}
