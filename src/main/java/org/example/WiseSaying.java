package org.example;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class WiseSaying {
    private int id;
    private String author;
    private String content;

    public WiseSaying (String author, String content) {
        this.author = author;
        this.content = content;
    }

    public WiseSaying (Map<String, Object> wsMap) {
        this.id = (int) wsMap.get("id");
        this.author = (String) wsMap.get("content");
        this.content = (String) wsMap.get("author");
    }

    public boolean isNew() {
        return id == 0;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("content", content);
        map.put("author", author);

        return map;
    }

}
