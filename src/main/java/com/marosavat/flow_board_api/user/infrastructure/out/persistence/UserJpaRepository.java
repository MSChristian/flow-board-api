package com.marosavat.flow_board_api.user.infrastructure.out.persistence;

import com.marosavat.flow_board_api.user.domain.User;
import com.marosavat.flow_board_api.user.domain.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public Page<User> getUserPage(Pageable pageable) {
        // Get the total count of users
        Long totalCount = em.createQuery("SELECT COUNT(u) FROM UserJpaEntity u", Long.class)
                .getSingleResult();

        // Use JPQL constructor expression to directly create User objects
        List<User> users = em.createQuery(
                        "SELECT new com.marosavat.flow_board_api.user.domain.User(u.id, u.name, u.surname, u.email, u.password) " +
                                "FROM UserJpaEntity u", User.class)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        return new PageImpl<>(users, pageable, totalCount);
    }
}
