package com.marosavat.flow_board_api.user.application;

import com.marosavat.flow_board_api.user.application.exception.UserEmailAlreadyTaken;
import com.marosavat.flow_board_api.user.domain.User;
import com.marosavat.flow_board_api.user.domain.event.UserCreatedEvent;
import com.marosavat.flow_board_api.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserCreator {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public User createUser(User user) {
        log.info("[User] Creating user");

        checkIfEmailIsAlreadyTaken(user);

        saveUser(user);
        return user;
    }

    private void checkIfEmailIsAlreadyTaken(User user) {
        if (new UserEmailChecker(userRepository).isEmailTaken(user.email())) {
            throw new UserEmailAlreadyTaken(user.email());
        }
    }

    private void saveUser(User user) {
        userRepository.createUser(user);
        eventPublisher.publishEvent(new UserCreatedEvent(user));
    }
}
