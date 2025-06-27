package com.marosavat.flow_board_api.user.infrastructure.out.persistence;

import com.marosavat.flow_board_api.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserJpaEntity {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;


    public UserJpaEntity(User user) {
        this.id = user.id();
        this.name = user.name();
        this.surname = user.surname();
        this.email = user.email();
    }
}
