package camp.tmp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TmpRepositoryRegistrar.class)
@SpringBootTest
class TmpRepositoryRegistrarTest {

    @Autowired
    TmpRepository repository;

    @Test
    void tmpRepositoryTest() {
        String newData = "NEW DATA";
        Long savedId = repository.save(newData);

        String result = repository.find(savedId);

        System.out.println("result = " + result);
    }

}