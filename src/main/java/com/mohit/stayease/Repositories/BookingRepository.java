package com.mohit.stayease.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.stayease.Entities.BookingEntity;
import com.mohit.stayease.Entities.HotelEntity;
import com.mohit.stayease.Entities.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    Optional<BookingEntity> findByPaymentSessionId(String sessionId);

    List<BookingEntity> findByHotel(HotelEntity hotel);

    List<BookingEntity> findByHotelAndCreatedAtBetween(HotelEntity hotel, LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<BookingEntity> findByUser(UserEntity user);
}
