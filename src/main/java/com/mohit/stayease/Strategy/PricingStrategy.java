package com.mohit.stayease.Strategy;

import java.math.BigDecimal;

import com.mohit.stayease.Entities.InventoryEntity;
public interface PricingStrategy {

    BigDecimal calculatePrice(InventoryEntity inventory);
}
