package com.marosavat.flow_board_api.notification.domain;

public interface NotificationSender {

    void send(Notification notification);
}
