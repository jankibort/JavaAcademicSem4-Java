package pl.jaz.jazapp.users;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserCreatorService {
    @PersistenceContext
    private EntityManager em;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void createUser(String username, String password) {
        var userEntity = new UserEntity();
        userEntity.setUsername(username);

//        userEntity.setPassword(passwordEncoder.encode());
//        var isPasswordCorrect = passwordEncoder.matches(password, userEntity.getPassword);

        em.persist(userEntity);
    }
}
