package org.sample.samplegateway.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("cards")
public class CardEntity implements Persistable<Integer> {
    @Id
    @Column("id")
    private Integer id;

    @Column("fk_user_id")
    private Integer userId;
    private String number;
    private String expiry;
    private String name;
    private Integer balance;

    @Override
    public boolean isNew() {
        return id == null;
    }
}
