package com.mohit.stayease.Dto;

import com.mohit.stayease.Entities.UserEntity;
import com.mohit.stayease.Enums.Gender;

import lombok.Data;

@Data
public class GuestDTO {
    private Long id;
    private String name;
    private Gender gender;
    private Integer age;
}
