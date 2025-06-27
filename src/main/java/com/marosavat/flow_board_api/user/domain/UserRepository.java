package com.marosavat.flow_board_api.user.domain;

public interface UserRepository {
    User createUser(User user);

    boolean isEmailTaken(String email);
}
