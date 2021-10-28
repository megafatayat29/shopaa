package com.pascal.shopaaboot.dto;

import java.sql.Date;

public class CustomerSearchDto {
    private String completeName;
    private String username;
    private Date birthDate;
    private String phone;
    private String email;
    private String gender;

    public CustomerSearchDto(String completeName, String username, Date birthDate, String phone, String email, String gender) {
        this.completeName = completeName;
        this.username = username;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
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
