package com.pascal.shopaaboot.service;

import com.pascal.shopaaboot.dto.CustomPage;
import com.pascal.shopaaboot.dto.CustomerSearchDto;
import com.pascal.shopaaboot.entity.Customer;
import com.pascal.shopaaboot.repo.CustomerRepository;
import com.pascal.shopaaboot.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerServiceDbImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        getCustomerById(customer.getId());
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String id) {
        if (!customerRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan");
        }
        return customerRepository.findById(id).get();
    }

    @Override
    public CustomPage<Customer> findCustomerByCriteria(CustomerSearchDto customerSearchDto, Pageable pageable) {
        Specification<Customer> specification = CustomerSpecification.getSpecification(customerSearchDto);
        Page<Customer> customerPage = customerRepository.findAll(specification, pageable);
        return new CustomPage<Customer>(customerPage);
    }
}
