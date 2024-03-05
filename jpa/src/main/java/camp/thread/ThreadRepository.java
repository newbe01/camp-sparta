package camp.thread;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ThreadRepository {

    @PersistenceContext
    EntityManager em;

    public Thread insertThread(Thread thread) {
        em.persist(thread);
        return thread;
    }

    public Thread selectThread(Long id) {
        return em.find(Thread.class, id);
    }

}
