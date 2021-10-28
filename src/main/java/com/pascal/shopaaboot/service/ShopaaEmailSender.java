package com.pascal.shopaaboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ShopaaEmailSender {
    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    CustomerService customerService;

    public void sendMail(String message, String idCustomer) {
        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setTo("angga.raditya@enigmacamp.com");
        mail.setTo("pascalbatch7@gmail.com");
//        mail.setFrom("megafatayat9@gmail.com");
        mail.setSubject("PEMBELIAN SHOPAA");
        mail.setText("Dear Pascal Batch 7, \n Anda berhasil melakukan pembelian pada Shopaa");
        javaMailSender.send(mail);
    }
}
