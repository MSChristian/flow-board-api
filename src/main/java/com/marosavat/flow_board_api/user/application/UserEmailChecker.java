package com.marosavat.flow_board_api.user.application;


import com.marosavat.flow_board_api.user.domain.UserRepository;

public class UserEmailChecker {

    private final UserRepository userRepository;
    public UserEmailChecker(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isEmailTaken(String email) {
        return userRepository.isEmailTaken(email);
    }
}
