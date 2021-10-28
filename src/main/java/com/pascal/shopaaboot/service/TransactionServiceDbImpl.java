package com.pascal.shopaaboot.service;

import com.pascal.shopaaboot.constant.ResponseMessage;
import com.pascal.shopaaboot.dto.ItemPurchaseDto;
import com.pascal.shopaaboot.dto.PurchaseDto;
import com.pascal.shopaaboot.entity.Customer;
import com.pascal.shopaaboot.entity.Transaction;
import com.pascal.shopaaboot.entity.Product;
import com.pascal.shopaaboot.exception.InsufficientStock;
import com.pascal.shopaaboot.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@Service
public class TransactionServiceDbImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @Override
    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        Product product = productService.getProductById(transaction.getProductId());
        if (product.getStock() < transaction.getQty()) {
            throw new InsufficientStock(String.format(ResponseMessage.INSUFFICIENT_STOCK, product.getName()));
        }
        product.decreaseStock(transaction);
        productService.updateProduct(product);
        transaction.setProduct(product);
        transaction.setBuyDate(new Date(System.currentTimeMillis()));
        transaction.setSubtotal(transaction.getQty()*product.getPrice());
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> createTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            createTransaction(transaction);
        }
        return transactions;
    }

    @Override
    public PurchaseDto createMultipleTransaction(PurchaseDto purchaseDto) {
        Customer customer = customerService.getById(purchaseDto.getCustomerId());
        for (ItemPurchaseDto itemPurchaseDto : purchaseDto.getItems()) {
            Product product = productService.getProductById(itemPurchaseDto.getProductId());
            Transaction transaction = new Transaction(customer, product, itemPurchaseDto.getQty(), product.getPrice()*itemPurchaseDto.getQty());
            try {
                createTransaction(transaction);
                itemPurchaseDto.setStatus("SUCCESS");
            } catch (ResponseStatusException e) {
                itemPurchaseDto.setStatus("FAILED");
            }
        }
        return purchaseDto;
    }
}
