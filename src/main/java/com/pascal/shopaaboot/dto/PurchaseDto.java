package com.pascal.shopaaboot.dto;

import java.util.List;

public class PurchaseDto {
    private String customerId;
    private List<ItemPurchaseDto> items;

    public PurchaseDto() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<ItemPurchaseDto> getItems() {
        return items;
    }
}
