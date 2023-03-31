package com.zyke.finfun.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test_entity")
@Data
@NoArgsConstructor
public class TestEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "val")
    private String value;
}
