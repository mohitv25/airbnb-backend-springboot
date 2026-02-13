package com.mohit.stayease.Service.Interfaces;

import com.mohit.stayease.Dto.BookingDTO;
import com.mohit.stayease.Dto.BookingRequest;
import com.mohit.stayease.Dto.GuestDTO;
import com.mohit.stayease.Dto.HotelReportDTO;
import com.mohit.stayease.Enums.BookingStatus;
import com.stripe.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    BookingDTO initialiseBooking(BookingRequest bookingRequest);

    BookingDTO addGuests(Long bookingId, List<GuestDTO> guestDtoList);

    String initiatePayments(Long bookingId);

    void capturePayment(Event event);

    void cancelBooking(Long bookingId);

    BookingStatus getBookingStatus(Long bookingId);

    List<BookingDTO> getAllBookingsByHotelId(Long hotelId);

    HotelReportDTO getHotelReport(Long hotelId, LocalDate startDate, LocalDate endDate);

    List<BookingDTO> getMyBookings();
}
