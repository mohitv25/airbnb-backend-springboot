package com.mohit.stayease.Dto;

import com.mohit.stayease.Entities.HotelEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPriceDTO {
    private HotelEntity hotel;
    private Double price;
}
