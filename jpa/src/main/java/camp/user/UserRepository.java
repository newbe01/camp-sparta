package camp.user;

import camp.tmp.SampleRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

//@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRepository extends SampleRepository<User, Long> {

//    public Optional<User> findByUsername(String userName);

}
