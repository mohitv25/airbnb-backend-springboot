package com.mohit.airbnb.Utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.mohit.airbnb.Entities.UserEntity;

public class AppUtils {

    public static UserEntity getCurrentUser() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
