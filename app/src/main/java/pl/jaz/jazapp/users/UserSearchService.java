package pl.jaz.jazapp.users;


import pl.jaz.jazapp.pojo.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
public class UserSearchService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Optional<UserEntity> findUser(String username, String password) {
        return em.createQuery("from UserEntity where username = :username AND password = :password", UserEntity.class)
                .setParameter("username", username).setParameter("password", password)
                .getResultList().stream()
                .findFirst();
    }
}
