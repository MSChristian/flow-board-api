package com.marosavat.flow_board_api.user.domain;

import com.marosavat.flow_board_api.user.domain.exception.InvalidUser;

import java.util.UUID;

public record User(
        UUID id,
        String name,
        String surname,
        String email
) {
    public User {
        if (id == null) {
            throw new InvalidUser("User id cannot be null");
        }

        if (name == null || name.isBlank()) {
            throw new InvalidUser("User name cannot be null or blank");
        }

        if (surname == null || surname.isBlank()) {
            throw new InvalidUser("User surname cannot be null or blank");
        }

        if (email == null || email.isBlank()) {
            throw new InvalidUser("User email cannot be null or blank");
        }
    }
}
