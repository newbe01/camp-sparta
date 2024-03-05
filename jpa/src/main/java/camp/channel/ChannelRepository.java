package camp.channel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ChannelRepository {

    @PersistenceContext
    EntityManager em;

    public Channel insertChannel(Channel channel) {
        em.persist(channel);
        return channel;
    }

    public Channel selectChannel(Long id) {
        return em.find(Channel.class, id);
    }

}
