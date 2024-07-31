package org.sample.samplegateway.dto;

import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class GetCustomerCardResponse {

    @JsonProperty("user")
    private UserDto user;
    @JsonProperty("cards")
    private List<CardDto> cards;
}

