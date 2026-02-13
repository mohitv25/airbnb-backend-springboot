package com.mohit.stayease.Service.Interfaces;

import com.mohit.stayease.Dto.ProfileUpdateRequestDTO;
import com.mohit.stayease.Dto.UserDTO;
import com.mohit.stayease.Entities.UserEntity;

public interface UserService {
    UserEntity getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDTO profileUpdateRequestDto);

    UserDTO getMyProfile();
}
