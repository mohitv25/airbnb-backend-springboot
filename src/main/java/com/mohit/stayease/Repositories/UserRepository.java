package com.mohit.stayease.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.stayease.Entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
