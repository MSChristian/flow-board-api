package com.marosavat.flow_board_api.user.domain.event;

import com.marosavat.flow_board_api.user.domain.User;

import java.util.UUID;

public record UserCreatedEvent(
        UUID id,
        String name,
        String surname,
        String email,
        String password
) {

    public UserCreatedEvent(User user) {
        this(user.id(),
                user.name(),
                user.surname(),
                user.email(),
                user.password());
    }
}
