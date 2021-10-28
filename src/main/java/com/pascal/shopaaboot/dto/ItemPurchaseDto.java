package com.pascal.shopaaboot.dto;

public class ItemPurchaseDto {
    private String productId;
    private Integer qty;
    private String status;

    public ItemPurchaseDto() {
    }

    public String getProductId() {
        return productId;
    }

    public Integer getQty() {
        return qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
