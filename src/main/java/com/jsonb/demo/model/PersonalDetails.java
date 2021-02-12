package com.jsonb.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PersonalDetails {
    private Address address;
    private String[] children;
    private String phoneNumber;
    private Double salary;
}
