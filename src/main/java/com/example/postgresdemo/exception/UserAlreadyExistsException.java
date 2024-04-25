package com.example.postgresdemo.exception;

import com.example.postgresdemo.dto.UserData;

public class UserAlreadyExistsException extends Exception {
    static final String PREDICATING_MESSAGE = "User with email %s already exists.";

    public UserAlreadyExistsException(final UserData user) {
        super(PREDICATING_MESSAGE.formatted(user.getEmail());
    }
}
