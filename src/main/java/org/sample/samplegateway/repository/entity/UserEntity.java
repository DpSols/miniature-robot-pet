package org.sample.samplegateway.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("users")
public class UserEntity implements Persistable<Integer> {
    @Id
    @Column("id")
    private Integer id;

    @Column("name")
    private String name;

    @Column("age")
    private Integer age;

    @Override
    public boolean isNew() {
        return id == null;
    }
}
