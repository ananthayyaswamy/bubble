package com.bubble.bubble.entity;

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
    @OneToMany(mappedBy = "appTable",cascade = CascadeType.ALL ,orphanRemoval = true)
    private Set<Column> column =new HashSet<>();

}
