package com.example.kafkapractice.dto.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
public class UserDetails {
    private BigInteger id;
    private String firstName;
    private String lastName;
    private BigInteger age;
}
