package com.marosavat.flow_board_api.notification.domain.exception;

public class NotificationNotSent extends RuntimeException {
    public NotificationNotSent(String message, Throwable cause) {
        super(message);
    }
}
