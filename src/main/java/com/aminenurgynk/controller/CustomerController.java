package com.aminenurgynk.controller;

import com.aminenurgynk.model.Customer;
import com.aminenurgynk.service.CustomerService;
import com.aminenurgynk.untility.ICrud;

import java.util.List;
import java.util.Optional;

public class CustomerController implements ICrud<Customer> {

    private CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }

    @Override
    public Customer save(Customer customer) {
        return customerService.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerService.update(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerService.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerService.findById(id);
    }
}
