package com.mohit.airbnb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.airbnb.Dto.GuestDTO;
import com.mohit.airbnb.Entities.GuestEntity;
import com.mohit.airbnb.Entities.UserEntity;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {
    List<GuestDTO> findByUser(UserEntity user);
}