package org.sample.samplegateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("users")
public class User {
    @Id
    @Column("id")
    private int id;

    @Column("name")
    private String name;

    @Column("age")
    private int age;
}
