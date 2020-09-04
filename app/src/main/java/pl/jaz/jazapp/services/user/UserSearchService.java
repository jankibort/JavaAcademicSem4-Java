package pl.jaz.jazapp.services.user;


import pl.jaz.jazapp.pojo.UserEntity;
import javax.enterprise.context.ApplicationScoped;
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

    @Transactional
    public Optional<UserEntity> getIdByUsername(String username) {
        return em.createQuery("select id from UserEntity where username = :username", UserEntity.class)
                .setParameter("username", username).getResultList().stream().findFirst();
    }

    @Transactional
    public Optional<UserEntity> getByUsername(String username) {
        return em.createQuery("from UserEntity where username = :username", UserEntity.class)
                .setParameter("username", username).getResultList().stream().findFirst();
    }

    @Transactional
    public Optional<UserEntity> getPassword(String username) {
        return em.createQuery("select password from UserEntity where username = :username", UserEntity.class)
                .setParameter("username", username).getResultList().stream().findFirst();
    }
}
