package com.marosavat.flow_board_api.user.infrastructure.out.persistence;

import com.marosavat.flow_board_api.user.domain.User;
import com.marosavat.flow_board_api.user.domain.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserJpaRepository implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User createUser(User user) {
        em.persist(new UserJpaEntity(user));
        return user;
    }

    @Override
    public boolean isEmailTaken(String email) {
        return !em.createQuery("SELECT u FROM UserJpaEntity u WHERE u.email = :email", UserJpaEntity.class)
                .setParameter("email", email)
                .getResultList()
                .isEmpty();
    }
}
