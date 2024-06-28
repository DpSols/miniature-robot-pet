package org.sample.samplegateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("user_dto")
public class User {
    @Id
    @Column("user_id")
    private int id;

    @Column("user_name")
    private String name;

    @Column("user_age")
    private int age;
}
