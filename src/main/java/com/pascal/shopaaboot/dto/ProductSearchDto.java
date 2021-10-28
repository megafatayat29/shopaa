package com.pascal.shopaaboot.dto;

public class ProductSearchDto {
    private String name;
    private String description;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer stock;

    public ProductSearchDto(String name, String description, Integer minPrice, Integer maxPrice, Integer stock) {
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }
}
