package com.pascal.shopaaboot.controller;

import com.pascal.shopaaboot.dto.CustomPage;
import com.pascal.shopaaboot.entity.Product;
import com.pascal.shopaaboot.entity.Store;
import com.pascal.shopaaboot.service.ProductService;
import com.pascal.shopaaboot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/stores")
    public CustomPage<Store> getAllStore(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
        return storeService.getAllStore(PageRequest.of(page, size));
    }

    @GetMapping("/store/{id}")
    public Store getStoreById(@PathVariable(name = "id") String id) {
        return storeService.getStoreById(id);
    }

    @GetMapping("/store/{id}/products")
    public List<Product> getProductFromThisStore(@PathVariable(name = "id") String id) {
//        return storeService.getAllProducts(id);
        return getStoreById(id).getProducts();
    }

    @PostMapping("/store")
    public Store createStore(@RequestBody Store store) {
        return storeService.createStore(store);
    }

    @DeleteMapping("/store")
    public void deleteStore(@RequestParam(name = "id") String id) {
        storeService.deleteStore(id);
    }

    @PutMapping("/store")
    public void updateStore(@RequestBody Store store) {
        storeService.updateStore(store);
    }

    @GetMapping("/store")
    public List<Store> getStoreByName(@RequestParam(name = "name") String name) {
        return storeService.getAllStoreByName(name);
    }

    @GetMapping("/storesbyaddress")
    public CustomPage<Store> getAllStoreByAddress(@RequestParam(name = "address") String address, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
        return storeService.getAllStoreByAddress(address,PageRequest.of(page, size));
    }

    @GetMapping("/store/search")
    public List<Store> getAllStoreByNameAndAddressIsContaining(@RequestParam(name = "name") String name, @RequestParam(name = "address") String address) {
        return storeService.getAllStoreByNameIsContainingAndAddressIsContaining(name, address);
    }
}
