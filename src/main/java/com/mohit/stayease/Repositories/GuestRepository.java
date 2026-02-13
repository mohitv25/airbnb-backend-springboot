package com.mohit.stayease.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.stayease.Dto.GuestDTO;
import com.mohit.stayease.Entities.GuestEntity;
import com.mohit.stayease.Entities.UserEntity;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {
    List<GuestDTO> findByUser(UserEntity user);
}