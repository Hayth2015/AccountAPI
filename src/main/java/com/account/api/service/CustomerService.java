package com.account.api.service;

import com.account.api.exception.CustomerNotFoundException;
import com.account.api.model.Customer;
import com.account.api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Could not find customer by id: " + id));

    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
