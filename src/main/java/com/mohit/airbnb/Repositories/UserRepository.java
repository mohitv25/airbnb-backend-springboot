package com.mohit.airbnb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.airbnb.Entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
