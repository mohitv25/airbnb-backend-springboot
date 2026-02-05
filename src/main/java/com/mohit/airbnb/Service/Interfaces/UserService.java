package com.mohit.airbnb.Service.Interfaces;

import com.mohit.airbnb.Dto.ProfileUpdateRequestDTO;
import com.mohit.airbnb.Dto.UserDTO;
import com.mohit.airbnb.Entities.UserEntity;

public interface UserService {
    UserEntity getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDTO profileUpdateRequestDto);

    UserDTO getMyProfile();
}
