package com.account.api.util;

import com.account.api.model.Account;
import com.account.api.model.Customer;
import com.account.api.model.DTO.AccountDTO;
import com.account.api.model.DTO.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConverterUtil {

    @Autowired
    private ModelMapper modelMapper;

    public AccountDTO convertToDTO(Account account) {
        return modelMapper.map(account, AccountDTO.class);
    }

    public CustomerDTO convertToDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> convertToDTO(List<Customer> customers) {
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }
}
