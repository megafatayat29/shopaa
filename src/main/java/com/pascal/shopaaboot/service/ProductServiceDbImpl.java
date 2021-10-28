package com.pascal.shopaaboot.service;

import com.pascal.shopaaboot.constant.ResponseMessageNotFound;
import com.pascal.shopaaboot.dto.CustomPage;
import com.pascal.shopaaboot.dto.ProductSearchDto;
import com.pascal.shopaaboot.entity.Product;
import com.pascal.shopaaboot.entity.Store;
import com.pascal.shopaaboot.exception.DataNotFoundException;
import com.pascal.shopaaboot.repo.ProductRepository;
import com.pascal.shopaaboot.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceDbImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StoreService storeService;

    @Override
    public CustomPage<Product> getAllProduct(Pageable pageable) {
        Page<Product> pageData = productRepository.findAll(pageable);
        CustomPage<Product> customPageData = new CustomPage<>(pageData);
        return customPageData;
    }

    @Override
    public Product getProductById(String id) {
        if (!productRepository.findById(id).isPresent()){
            throw new DataNotFoundException(String.format(ResponseMessageNotFound.DATA_NOT_FOUND,
                    Product.entityName, id));
        }
        Product product = productRepository.findById(id).get();
        product.setStoreId(product.getStore().getId());
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        Store store = storeService.getStoreById(product.getStoreId());
        product.setStore(store);
        return productRepository.save(product);
    }

    @Override
    public List<Product> createProduct(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.delete(getProductById(id));
    }

    @Override
    public Product updateProduct(Product product) {
        getProductById(product.getId());
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getAllProductByNameIsContainingAndPriceBetween(String name, Integer min, Integer max, Pageable pageable) {
        Page<Product> pageData = productRepository.findAllByNameIsContainingAndPriceBetween(name, min, max, pageable);
        return pageData;
    }

    @Override
    public CustomPage<Product> findProductByCriteria(ProductSearchDto productSearchDto, Pageable pageable) {
        Specification<Product> specification = ProductSpecification.getSpecification(productSearchDto);
        Page<Product> productPage = productRepository.findAll(specification, pageable);
        return new CustomPage<Product>(productPage);
    }

    @Override
    public void saveAllProductsByStoreId(String storeId, List<Product> products) {
        Store store = storeService.getStoreById(storeId);
        for (Product product : products) {
            product.setStore(store);
        }
        store.addProducts(products);
        storeService.updateStore(store);
    }
}
