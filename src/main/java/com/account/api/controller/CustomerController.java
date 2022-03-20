package com.account.api.controller;

import com.account.api.model.Customer;
import com.account.api.model.DTO.CustomerDTO;
import com.account.api.service.CustomerService;
import com.account.api.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    private ConverterUtil converterUtil;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID customerId){
        Customer customer = customerService.findCustomerById(customerId);
        CustomerDTO customerDTO = converterUtil.convertToDTO(customer);
        return ResponseEntity.ok(customerDTO);
        //return ResponseEntity.ok(customerService.findCustomerById(customerId));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
        List<Customer> customers = customerService.findAllCustomers();
        List<CustomerDTO> customerDTOList = converterUtil.convertToDTO(customers);
        return ResponseEntity.ok(customerDTOList);
    }

}
