package com.pascal.shopaaboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "m_store")
public class Store {
    public static final String entityName = "STORE";

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    private String name;
    private String address;
    private String phone;
    private String siup;
    private String npwp;

    @OneToMany(mappedBy = "store", cascade = CascadeType.MERGE)
    private List<Product> products = new ArrayList<>();

    public Store() {
    }

    public Store(String name, String address, String phone, String siup, String npwp) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.siup = siup;
        this.npwp = npwp;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getSiup() {
        return siup;
    }

    public String getNpwp() {
        return npwp;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
