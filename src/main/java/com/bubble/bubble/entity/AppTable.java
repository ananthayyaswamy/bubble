package com.bubble.bubble.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AppTable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long appTableId;
    private String physicalName;
    private String logicalName;
    private String primaryKey;
    @JsonManagedReference
    @OneToMany(mappedBy = "appTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Column> column = new HashSet<>();
    //////////////////
//
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id")
    private App app;

///////
}