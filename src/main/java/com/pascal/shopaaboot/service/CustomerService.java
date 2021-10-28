package com.pascal.shopaaboot.service;

import com.pascal.shopaaboot.dto.CustomPage;
import com.pascal.shopaaboot.dto.CustomerSearchDto;
import com.pascal.shopaaboot.entity.Customer;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer getCustomerById(String id);
    public CustomPage<Customer> findCustomerByCriteria(CustomerSearchDto customerSearchDto, Pageable pageable);
}
