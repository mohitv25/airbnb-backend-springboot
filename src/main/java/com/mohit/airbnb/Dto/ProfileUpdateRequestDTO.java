package com.mohit.airbnb.Dto;

import lombok.Data;

import java.time.LocalDate;

import com.mohit.airbnb.Enums.Gender;

@Data
public class ProfileUpdateRequestDTO {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
}
