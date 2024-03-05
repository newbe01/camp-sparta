package camp.user;

import camp.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public User insertUser(User user) {
        em.persist(user);
        return user;
    }

    public User selectUser(Long id) {
        return em.find(User.class, id);
    }

}
