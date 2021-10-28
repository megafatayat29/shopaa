package com.pascal.shopaaboot.controller;

import com.pascal.shopaaboot.dto.PurchaseDto;
import com.pascal.shopaaboot.entity.Transaction;
import com.pascal.shopaaboot.service.ShopaaEmailSender;
import com.pascal.shopaaboot.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    ShopaaEmailSender shopaaEmailSender;

    @PostMapping("/transaction")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

//    @PostMapping("/transactions")
//    public List<Transaction> createTransactions(@RequestBody List<Transaction> transactions) {
//        return transactionService.createTransactions(transactions);
//    }

    @PostMapping("/transactions")
    public PurchaseDto createMultipleTransactions(@RequestBody PurchaseDto purchaseDto) {
        return transactionService.createMultipleTransaction(purchaseDto);
    }

    @PostMapping("/kirim")
    public void kirimEmail() {
        shopaaEmailSender.sendMail("","");
    }
}
