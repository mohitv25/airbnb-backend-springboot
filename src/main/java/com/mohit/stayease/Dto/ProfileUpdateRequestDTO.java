package com.mohit.stayease.Dto;

import lombok.Data;

import java.time.LocalDate;

import com.mohit.stayease.Enums.Gender;

@Data
public class ProfileUpdateRequestDTO {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
}
