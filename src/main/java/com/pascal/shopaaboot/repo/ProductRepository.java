package com.pascal.shopaaboot.repo;

import com.pascal.shopaaboot.dto.CustomPage;
import com.pascal.shopaaboot.entity.Product;
import com.pascal.shopaaboot.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
    public Page<Product> findAllByNameIsContainingAndPriceBetween(String name, Integer min, Integer max, Pageable pageable);

}
