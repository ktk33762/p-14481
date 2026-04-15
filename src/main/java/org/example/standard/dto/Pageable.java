package org.example.standard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pageable {
    private final int pageNum;
    private final int pageSize;

    public Pageable(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public long getSkipCount() {
        return (pageNum - 1) * pageSize;
    }
}
