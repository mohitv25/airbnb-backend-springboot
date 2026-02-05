package com.mohit.airbnb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.airbnb.Entities.RoomEntity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity,Long> {
}
