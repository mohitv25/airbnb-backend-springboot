package com.mohit.airbnb.Service.Interfaces;

import com.mohit.airbnb.Dto.BookingDTO;
import com.mohit.airbnb.Dto.BookingRequest;
import com.mohit.airbnb.Dto.GuestDTO;
import com.mohit.airbnb.Dto.HotelReportDTO;
import com.mohit.airbnb.Enums.BookingStatus;
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
