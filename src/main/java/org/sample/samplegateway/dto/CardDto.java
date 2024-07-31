package org.sample.samplegateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CardDto {
    private Integer id;
    private Integer userId;
    private String number;
    private String expiry;
    private String name;
    private Integer balance;

}
