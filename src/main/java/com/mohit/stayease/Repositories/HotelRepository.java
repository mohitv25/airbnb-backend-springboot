package com.mohit.stayease.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.stayease.Entities.HotelEntity;
import com.mohit.stayease.Entities.UserEntity;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity,Long> {
    List<HotelEntity> findByOwner(UserEntity user);
}
