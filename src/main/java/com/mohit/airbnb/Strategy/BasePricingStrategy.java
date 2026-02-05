package com.mohit.airbnb.Strategy;

import java.math.BigDecimal;

import com.mohit.airbnb.Entities.InventoryEntity;

public class BasePricingStrategy implements PricingStrategy{
    @Override
    public BigDecimal calculatePrice(InventoryEntity inventory) {
        return inventory.getRoom().getBasePrice();
    }
}
