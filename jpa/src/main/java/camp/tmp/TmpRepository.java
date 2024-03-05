package camp.tmp;

import java.util.HashMap;
import lombok.Setter;

@Setter
public class TmpRepository {

    private HashMap<Long, String> dataTable;

    public String find(Long id) {
        return dataTable.getOrDefault(id, "");
    }

    public Long save(String data) {
        var newId = Long.valueOf(dataTable.size());

        this.dataTable.put(newId, data);
        return newId;
    }

}
