package com.marosavat.flow_board_api.user.domain.event;

import com.marosavat.flow_board_api.user.domain.User;

public record UserCreatedEvent(User user) { }
