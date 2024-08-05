package org.springframework.boot.exam2.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;


public class PagingDto {
    private int pageSize;
    private int pageNumber;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
