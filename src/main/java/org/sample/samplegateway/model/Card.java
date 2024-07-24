package org.sample.samplegateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Table("cards")
public class Card {
    @Id
    @Column("id")
    private int id;

    @Column("fk_user_id")
    private int userId;
    private String number;
    private LocalDate expiry;
    private String name;
    private int balance;
}
