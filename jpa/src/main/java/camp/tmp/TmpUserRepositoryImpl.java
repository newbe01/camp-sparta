package camp.tmp;

import camp.user.User;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TmpUserRepositoryImpl implements TmpUserRepository<User>{

    @Autowired
    EntityManager em;

    @Override
    public void delete(User entity) {
        System.out.println("delete");
        em.remove(entity);
    }

    @Override
    public List<String> findNameAll() {
        return em.createQuery("select u.username from User u", String.class).getResultList();
    }
}
