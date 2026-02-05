package com.mohit.airbnb.Dto;

import com.mohit.airbnb.Entities.UserEntity;
import com.mohit.airbnb.Enums.Gender;

import lombok.Data;

@Data
public class GuestDTO {
    private Long id;
    private String name;
    private Gender gender;
    private Integer age;
}
