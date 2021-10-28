package com.pascal.shopaaboot.service;

import com.pascal.shopaaboot.dto.CustomPage;
import com.pascal.shopaaboot.entity.Product;
import com.pascal.shopaaboot.entity.Store;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StoreService {
    public CustomPage<Store> getAllStore(Pageable pageable);
    public Store getStoreById(String id);
    public Store createStore(Store store);
    public void deleteStore(String id);
    public void updateStore(Store store);
    public List<Store> getAllStoreByName(String name);
    public CustomPage<Store> getAllStoreByAddress(String address, Pageable pageable);
    public List<Store> getAllStoreByNameIsContainingAndAddressIsContaining(String name, String address);
    public List<Product> getAllProducts(String id);
}
