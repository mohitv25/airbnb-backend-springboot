package com.mohit.stayease.Strategy;

import java.math.BigDecimal;

import com.mohit.stayease.Entities.InventoryEntity;

public class BasePricingStrategy implements PricingStrategy{
    @Override
    public BigDecimal calculatePrice(InventoryEntity inventory) {
        return inventory.getRoom().getBasePrice();
    }
}
