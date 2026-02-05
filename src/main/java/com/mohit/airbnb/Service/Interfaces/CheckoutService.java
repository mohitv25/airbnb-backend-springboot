package com.mohit.airbnb.Service.Interfaces;


import com.mohit.airbnb.Entities.BookingEntity;

public interface CheckoutService {

    String getCheckoutSession(BookingEntity booking, String successUrl, String failureUrl);

}
