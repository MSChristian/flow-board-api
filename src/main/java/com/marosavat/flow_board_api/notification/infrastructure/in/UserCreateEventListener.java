package com.marosavat.flow_board_api.notification.infrastructure.in;

import com.marosavat.flow_board_api.notification.application.UserCreatedNotificationSender;
import com.marosavat.flow_board_api.user.domain.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserCreateEventListener {

    private final UserCreatedNotificationSender userCreatedNotificationSender;

    @ApplicationModuleListener
    public void onUserCreated(UserCreatedEvent event) {
        log.info("[User] User created event received");
        userCreatedNotificationSender.execute(event);
    }
}
