package com.jsonb.demo.model;

import lombok.Data;

@Data
public class PersonalDetails {

    private Address address;
    private String[] children;
    private String phoneNumber;
    private Double salary;
}
