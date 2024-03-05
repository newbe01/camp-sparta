package camp.tmp;

import java.util.List;

public interface TmpUserRepository<T> {

    void delete(T entity);

    List<String> findNameAll();

}
