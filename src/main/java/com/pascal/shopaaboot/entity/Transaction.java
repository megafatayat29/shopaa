package com.pascal.shopaaboot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tx_customer_enroll_product")
public class Transaction {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Transient
    private String customerId;
    @Transient
    private String productId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer qty;
    private Integer subtotal;
    protected Date buyDate;

    public Transaction() {
    }

    public Transaction(Customer customer, Product product, Integer qty, Integer subtotal) {
        this.customer = customer;
        this.product = product;
        this.qty = qty;
        this.subtotal = subtotal;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQty() {
        return qty;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductId() {
        return productId;
    }
}
