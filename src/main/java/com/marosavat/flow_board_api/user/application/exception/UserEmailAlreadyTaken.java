package com.marosavat.flow_board_api.user.application.exception;

public class UserEmailAlreadyTaken extends RuntimeException {
    public UserEmailAlreadyTaken(String email) {
        super("User with email " + email + " already exists");
    }
}
