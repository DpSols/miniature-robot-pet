package org.sample.samplegateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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
    private String expiry;
    private String name;
    private int balance;

    public void setExpiry(String expiry) {
        if (!expiry.matches("^[0-9]{2}/[0-9]{2}$")) {
            throw new IllegalArgumentException("Expiry date must be in MM/YY format");
        }
        this.expiry = expiry;
    }
}
