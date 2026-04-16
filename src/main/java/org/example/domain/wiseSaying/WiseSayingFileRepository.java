package org.example.domain.wiseSaying;

import org.example.WiseSaying;
import org.example.standard.util.Util;

import java.util.Map;

public class WiseSayingFileRepository {
    public void save(WiseSaying wiseSaying) {
        if (wiseSaying.getId() == 0) {
            int newId = getLastId() + 1;
            setLastId(newId);

            wiseSaying.setId(newId);
        }

        Map<String, Object> wsMap = wiseSaying.toMap();

        String wsJson = Util.json.toString(wsMap);

        Util.file.set("db/wiseSaying/%d.json".formatted(wiseSaying.getId()), wsJson);
    }

    private void setLastId(int id) {
        Util.file.set("db/wiseSaying/lastId.txt", String.valueOf(id));
    }

    private int getLastId() {
        String lastId = Util.file.get("db/wiseSaying/lastId.txt", "");

        int id = Integer.parseInt(lastId);

        return id;
    }

    public WiseSaying findById(int id) {
        String wsJson = Util.file.get("db/wiseSaying/%d.json".formatted(id), "");

        if (wsJson.isBlank()) return null;

        Map<String, Object> wiseSayingMap = Util.json.toMap(wsJson);


        WiseSaying wiseSaying = new WiseSaying(wiseSayingMap);

        return wiseSaying;
    }

    public boolean delete(WiseSaying wiseSaying) {
        String filePath = "db/wiseSaying/%d.json".formatted(wiseSaying.getId());

        return Util.file.delete(filePath);
    }
}
