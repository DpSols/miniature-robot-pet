package org.sample.samplegateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private int id;

    private String name;

    private int age;
}
