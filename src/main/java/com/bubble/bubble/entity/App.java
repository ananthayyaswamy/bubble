package com.bubble.bubble.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "apps")
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appId;
    private String appName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_table_id")
    private User userTable;
}
