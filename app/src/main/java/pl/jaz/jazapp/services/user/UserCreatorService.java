package pl.jaz.jazapp.services.user;


import pl.jaz.jazapp.pojo.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserCreatorService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createUser(String username, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);

        em.persist(userEntity);
    }
}
