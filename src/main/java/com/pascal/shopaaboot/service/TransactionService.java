package com.pascal.shopaaboot.service;

import com.pascal.shopaaboot.dto.PurchaseDto;
import com.pascal.shopaaboot.entity.Customer;
import com.pascal.shopaaboot.entity.Transaction;
import com.pascal.shopaaboot.entity.Product;

import java.util.List;

public interface TransactionService {
    public Transaction createTransaction(Transaction transaction);
    public List<Transaction> createTransactions(List<Transaction> transaction);
    public PurchaseDto createMultipleTransaction(PurchaseDto purchaseDto);
}
