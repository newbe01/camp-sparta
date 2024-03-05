package camp.tmp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.user.User;
import camp.user.UserRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class TmpUserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void tmpUserRepositoryDeleteTest() {
        User user = User.builder().username("test").password("test").build();
        userRepository.save(user);

        userRepository.delete(user);

    }

    @Test
    void findNameAllTest() {
        User user = User.builder().username("test").password("test").build();
        User user2 = User.builder().username("test").password("test").build();
        userRepository.save(user);
        userRepository.save(user2);

        List<String> result = userRepository.findNameAll();

        assertThat(result).contains("test");

    }
}