package com.marosavat.flow_board_api.notification.domain.event;

import com.marosavat.flow_board_api.notification.domain.Notification;

public record NotificationSentEvent(Notification notification) {
}
