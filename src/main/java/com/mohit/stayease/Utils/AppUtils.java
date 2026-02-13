package com.mohit.stayease.Utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.mohit.stayease.Entities.UserEntity;

public class AppUtils {

    public static UserEntity getCurrentUser() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
