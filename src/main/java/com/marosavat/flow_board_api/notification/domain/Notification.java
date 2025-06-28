package com.marosavat.flow_board_api.notification.domain;

public record Notification(
        String title,
        String content,
        NotificationType type,
        String recipient
) {

    public static Notification userNotification(String title, String content, String recipient) {
        return new Notification(title, content, NotificationType.USER, recipient);
    }
}
