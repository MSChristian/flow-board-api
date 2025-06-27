package com.marosavat.flow_board_api.user.domain.exception;

public class InvalidUser extends RuntimeException {
    public InvalidUser(String message) {
        super(message);
    }
}
