package com.pascal.shopaaboot.repo;

import com.pascal.shopaaboot.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, String> {
    public List<Store> findAllByName(String name);
    public Page<Store> findAllByAddress(String address, Pageable pageable);
    public List<Store> findAllByNameIsContainingAndAddressIsContaining(String name, String address);
}
