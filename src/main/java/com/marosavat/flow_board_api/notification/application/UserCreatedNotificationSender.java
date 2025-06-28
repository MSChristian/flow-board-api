package com.marosavat.flow_board_api.notification.application;

import com.marosavat.flow_board_api.notification.domain.Notification;
import com.marosavat.flow_board_api.notification.domain.NotificationRepository;
import com.marosavat.flow_board_api.notification.domain.event.NotificationSentEvent;
import com.marosavat.flow_board_api.user.domain.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserCreatedNotificationSender {

    private final NotificationRepository notificationRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void execute(UserCreatedEvent userEvent) {
        log.info("[Notification] Sending notification to user");
        Notification notification = buildUserNotification(userEvent);
        notificationRepository.save(notification);
        eventPublisher.publishEvent(new NotificationSentEvent(notification));
    }

    private static Notification buildUserNotification(UserCreatedEvent userEvent) {
        String title = "User created";
        String content = "An user was created with following email" + userEvent.email();
        return Notification.userNotification(title, content);
    }
}
