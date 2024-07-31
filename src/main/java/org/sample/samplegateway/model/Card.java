package org.sample.samplegateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Card {
    private int id;
    private int userId;
    private String number;
    private String expiry;
    private String name;
    private int balance;
}
