package camp.tmp;

import camp.user.User;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface SampleRepository<User, ID extends Serializable> extends Repository<camp.user.User, ID> {

    camp.user.User save (camp.user.User entity);

    Optional<camp.user.User> findByUsername(String username);

}
