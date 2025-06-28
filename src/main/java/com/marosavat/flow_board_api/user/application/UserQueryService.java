package com.marosavat.flow_board_api.user.application;

import com.marosavat.flow_board_api.user.domain.User;
import com.marosavat.flow_board_api.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserQueryService {

    private final UserRepository userRepository;

    public Page<User> getUserPage(Pageable pageable) {
        return userRepository.getUserPage(pageable);
    }
}
