package camp.user;

import camp.tmp.TmpUserRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
@Repository
public interface UserRepository extends JpaRepository<User, Long>, TmpUserRepository<User> {

//    public Optional<User> findByUsername(String userName);

    @Query("select u, u.password as custom_field from User u where u.username = :username")
    List<User> findByUsernameCustomField(String username, Sort sort);

    @Query("select u from User u where u.username = :username")
    List<User> findByUsername(String username, Sort sort);
}
