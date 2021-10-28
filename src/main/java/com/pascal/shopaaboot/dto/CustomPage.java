package com.pascal.shopaaboot.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class CustomPage<T>{
    private List<T> data;
    private Integer page;
    private Integer size;
    private Long totalRows;
    private Integer totalPage;

    public CustomPage(Page<T> pageData) {
        this.data = pageData.getContent();
        this.page = pageData.getPageable().getPageNumber();
        this.size = pageData.getPageable().getPageSize();
        this.totalRows = pageData.getTotalElements();
        this.totalPage = pageData.getTotalPages();
    }

    public List<T> getData() {
        return data;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public Long getTotalRows() {
        return totalRows;
    }

    public Integer getTotalPage() {
        return totalPage;
    }
}
