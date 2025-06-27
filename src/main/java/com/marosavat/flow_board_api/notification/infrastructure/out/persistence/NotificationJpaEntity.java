package com.marosavat.flow_board_api.notification.infrastructure.out.persistence;

import com.marosavat.flow_board_api.notification.domain.Notification;
import com.marosavat.flow_board_api.notification.domain.NotificationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
public class NotificationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type;

    public NotificationJpaEntity(Notification notification) {
        this.title = notification.title();
        this.content = notification.content();
        this.type = notification.type();
    }

    public Notification toDomain() {
        return new Notification(title, content, type);
    }
}
