package com.aminenurgynk.service;

import com.aminenurgynk.model.Customer;
import com.aminenurgynk.repository.CustomerRepository;
import com.aminenurgynk.untility.ICrud;

import java.util.List;
import java.util.Optional;

public class CustomerService implements ICrud<Customer> {

    private CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }
}
