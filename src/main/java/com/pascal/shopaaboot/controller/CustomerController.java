package com.pascal.shopaaboot.controller;

import com.pascal.shopaaboot.dto.CustomPage;
import com.pascal.shopaaboot.dto.CustomerSearchDto;
import com.pascal.shopaaboot.entity.Customer;
import com.pascal.shopaaboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") String id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customer")
    public CustomPage<Customer> getCustomerByCriteria(@RequestParam(required = false) String completeName,
                                                      @RequestParam(required = false) String username,
                                                      @RequestParam(required = false) Date birthDate,
                                                      @RequestParam(required = false) String phone,
                                                      @RequestParam(required = false) String email,
                                                      @RequestParam(required = false) String gender,
                                                      @RequestParam(name = "size") Integer size,
                                                      @RequestParam(name = "page") Integer page) {
        CustomerSearchDto customerSearchDto = new CustomerSearchDto(completeName, username, birthDate, phone, email, gender);
        return customerService.findCustomerByCriteria(customerSearchDto, PageRequest.of(page, size));
    }
}
