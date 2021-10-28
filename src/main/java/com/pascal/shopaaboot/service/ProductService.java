package com.pascal.shopaaboot.service;

import com.pascal.shopaaboot.dto.CustomPage;
import com.pascal.shopaaboot.dto.ProductSearchDto;
import com.pascal.shopaaboot.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public CustomPage<Product> getAllProduct(Pageable pageable);
    public Product getProductById(String id);
    public Product createProduct(Product product);
    public List<Product> createProduct(List<Product> productList);
    public void deleteProduct(String id);
    public Product updateProduct(Product product);
    public Page<Product> getAllProductByNameIsContainingAndPriceBetween(String name, Integer min, Integer max, Pageable pageable);
    public CustomPage<Product> findProductByCriteria(ProductSearchDto productSearchDto, Pageable pageable);
    public void saveAllProductsByStoreId(String storeId, List<Product> products);
}
