package com.pascal.shopaaboot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "mst_customer")
public class Customer {
    public static final String entityName = "CUSTOMER";

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    private String completeName;
    private String username;
    private Date birthDate;
    private String phone;
    private String email;
    private String gender;

    public Customer() {
    }

    public Customer(String id, String completeName, String username, Date birthDate, String phone, String email, String gender) {
        this.id = id;
        this.completeName = completeName;
        this.username = username;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getCompleteName() {
        return completeName;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
