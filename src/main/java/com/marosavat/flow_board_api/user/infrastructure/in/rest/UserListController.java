package com.marosavat.flow_board_api.user.infrastructure.in.rest;

import com.marosavat.flow_board_api.user.application.UserQueryService;
import com.marosavat.flow_board_api.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserListController {

    private final UserQueryService userQueryService;

    @GetMapping
    public ResponseEntity<Page<User>> listUsers(Pageable pageable) {
        return ResponseEntity.ok(userQueryService.getUserPage(pageable));
    }
}
