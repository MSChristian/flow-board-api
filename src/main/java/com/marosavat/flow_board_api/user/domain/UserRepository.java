package com.marosavat.flow_board_api.user.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {
    User createUser(User user);

    boolean isEmailTaken(String email);

    Page<User> getUserPage(Pageable pageable);
}
