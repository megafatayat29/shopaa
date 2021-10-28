package com.pascal.shopaaboot.service;

import com.pascal.shopaaboot.constant.ResponseMessageNotFound;
import com.pascal.shopaaboot.dto.CustomPage;
import com.pascal.shopaaboot.entity.Product;
import com.pascal.shopaaboot.entity.Store;
import com.pascal.shopaaboot.exception.DataNotFoundException;
import com.pascal.shopaaboot.repo.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StoreServiceDbImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    ProductService productService;

    @Override
    public CustomPage<Store> getAllStore(Pageable pageable) {
        Page<Store> pageData = storeRepository.findAll(pageable);
        CustomPage<Store> customPageData = new CustomPage<>(pageData);
        return customPageData;
    }

    @Override
    public Store getStoreById(String id) {
        if (!storeRepository.findById(id).isPresent()){
            throw new DataNotFoundException(String.format(ResponseMessageNotFound.DATA_NOT_FOUND,
                    Store.entityName, id));
        }
        return storeRepository.findById(id).get();
    }

    @Override
    public Store createStore(Store store) {
        //...
        return storeRepository.save(store);
    }

    @Override
    public void deleteStore(String id) {
        storeRepository.delete(getStoreById(id));
    }

    @Override
    public void updateStore(Store store) {
        getStoreById(store.getId());
        storeRepository.save(store);
    }

    @Override
    public List<Store> getAllStoreByName(String name) {
        return storeRepository.findAllByName(name);
    }

    @Override
    public CustomPage<Store> getAllStoreByAddress(String address, Pageable pageable) {
        Page<Store> pageData = storeRepository.findAllByAddress(address, pageable);
        CustomPage<Store> customPageData = new CustomPage<>(pageData);
        return customPageData;
    }

    @Override
    public List<Store> getAllStoreByNameIsContainingAndAddressIsContaining(String name, String address) {
        return storeRepository.findAllByNameIsContainingAndAddressIsContaining(name, address);
    }

    @Override
    public List<Product> getAllProducts(String id) {
        Store store = storeRepository.findById(id).get();
        List<Product> products = store.getProducts();
        return products;
    }
}
