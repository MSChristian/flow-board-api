package com.marosavat.flow_board_api.notification.infrastructure.out.persistence;

import com.marosavat.flow_board_api.notification.domain.Notification;
import com.marosavat.flow_board_api.notification.domain.NotificationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class NotificationJpaRepository implements NotificationRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Notification notification) {
        NotificationJpaEntity entity = new NotificationJpaEntity(notification);
        em.persist(entity);
        log.debug("Saved notification: {}", entity.getId());
    }

}
