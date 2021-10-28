package com.pascal.shopaaboot.service;

import java.util.List;

public interface CrudService<T> {
    public T create(T t);
    public T getById(String id);
    public void deleteById(String id);
    public List<T> findAll();
    public T update(T t);
}
