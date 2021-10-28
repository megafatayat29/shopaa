package com.pascal.shopaaboot.controller;

import com.pascal.shopaaboot.dto.CustomPage;
import com.pascal.shopaaboot.dto.ProductSearchDto;
import com.pascal.shopaaboot.entity.Product;
import com.pascal.shopaaboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public CustomPage<Product> getAllProducts(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
        return productService.getAllProduct(PageRequest.of(page, size));
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(name = "id") String id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

//    @PostMapping("/products")
//    public List<Product> createProducts(@RequestBody List<Product> productList) {
//        return productService.createProduct(productList);
//    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestParam(name = "id") String id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/product/search")
    public CustomPage<Product> getProductByNameAndPrice(@RequestParam(required = false) String name,
                                                  @RequestParam(required = false) Integer minPrice,
                                                  @RequestParam(required = false) Integer maxPrice,
                                                  @RequestParam(name = "size") Integer size,
                                                   @RequestParam(name = "page") Integer page) {
        Page<Product> pageData = productService.getAllProductByNameIsContainingAndPriceBetween(name, minPrice, maxPrice, PageRequest.of(page, size));
        CustomPage<Product> customPage = new CustomPage<>(pageData);
        return customPage;
    }

    @GetMapping("/products/criteria")
    public CustomPage<Product> getProductByCriteria(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String description,
                                                        @RequestParam(required = false) Integer minPrice,
                                                        @RequestParam(required = false) Integer maxPrice,
                                                        @RequestParam(required = false) Integer stock,
                                                        @RequestParam(name = "size") Integer size,
                                                        @RequestParam(name = "page") Integer page) {
        ProductSearchDto productSearchDto = new ProductSearchDto(name, description, minPrice, maxPrice, stock);
        return productService.findProductByCriteria(productSearchDto, PageRequest.of(page, size));
    }

    @GetMapping("/coba")
    public void coba(@RequestParam(required = false) String name) {
        System.out.println(name);
    }

    @PostMapping("/products")
    public void saveProductsByStoreId(@RequestParam(name = "storeId") String storeId, @RequestBody List<Product> products) {
        productService.saveAllProductsByStoreId(storeId, products);
    }

}
