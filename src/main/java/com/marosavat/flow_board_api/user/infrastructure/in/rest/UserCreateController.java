package com.marosavat.flow_board_api.user.infrastructure.in.rest;

import com.marosavat.flow_board_api.user.application.UserCreator;
import com.marosavat.flow_board_api.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserCreateController {

    private final UserCreator userCreator;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userCreator.createUser(user);
    }
}
