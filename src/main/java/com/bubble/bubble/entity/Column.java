package com.bubble.bubble.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="columns")
public class Column {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long columnId;
    private String physicalName;
    private String logicalName;
    private String dataType;
    private String dataLength;
    private String defaultValue;
    private String allowedValue;
    @jakarta.persistence.Column(name = "is_unique")
    private String unique;
    @jakarta.persistence.Column(name = "is_nullable")
    private String nullable;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_table_id")
    private AppTable appTable;

}
