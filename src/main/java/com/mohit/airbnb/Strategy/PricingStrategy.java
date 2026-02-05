package com.mohit.airbnb.Strategy;

import java.math.BigDecimal;

import com.mohit.airbnb.Entities.InventoryEntity;
public interface PricingStrategy {

    BigDecimal calculatePrice(InventoryEntity inventory);
}
