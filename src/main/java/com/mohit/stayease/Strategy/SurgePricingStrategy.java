package com.mohit.stayease.Strategy;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import com.mohit.stayease.Entities.InventoryEntity;

@RequiredArgsConstructor
public class SurgePricingStrategy implements PricingStrategy{

    private final PricingStrategy wrapped;

    @Override
    public BigDecimal calculatePrice(InventoryEntity inventory) {
        BigDecimal price = wrapped.calculatePrice(inventory);
        return price.multiply(inventory.getSurgeFactor());
    }
}
