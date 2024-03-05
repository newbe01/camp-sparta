package camp.userChannel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserChannelRepository {

    @PersistenceContext
    EntityManager em;

    public UserChannel insertUserChannel(UserChannel userChannel) {
        em.persist(userChannel);
        return userChannel;
    }

    public UserChannel selectUserChannel(Long id) {
        return em.find(UserChannel.class, id);
    }

}
