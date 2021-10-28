package com.pascal.shopaaboot;

import com.pascal.shopaaboot.entity.Product;
import com.pascal.shopaaboot.entity.Store;
import com.pascal.shopaaboot.repo.ProductRepository;
import com.pascal.shopaaboot.repo.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerConsole implements CommandLineRunner {
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        //TANPA CASCADE
//        Store store = new Store("Toko Lama", "Kebagusan", "085876877698", "SIUP-900","90900909");
//        Product product1 = new Product("Odol", "Pasta gigi harum", 9000,8);
//        Product product2 = new Product("Lulur", "Lulur mandi harum", 7000,9);
//
//        Store savedStore = storeRepository.save(store);
//        product1.setStore(savedStore);
//        product2.setStore(savedStore);



    }
}
