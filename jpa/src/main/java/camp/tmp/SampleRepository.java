package camp.tmp;

import camp.user.User;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface SampleRepository<User, ID extends Serializable> extends Repository<User, ID> {

    User save (User entity);

    Optional<User> findByUsername(String username);

}
