package com.account.api.util;

import com.account.api.TestUtil;
import com.account.api.model.Account;
import com.account.api.model.Customer;
import com.account.api.model.DTO.AccountDTO;
import com.account.api.model.DTO.CustomerDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterUtilTest {

    @Autowired
    private static ModelMapper modelMapper;

    @BeforeAll
    static void setUp() {
        modelMapper = new ModelMapper();
    }

    @Test
    void testConvertAccountEntityToAccountDTO() {
        Account account = TestUtil.createAccount();
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);

        assertEquals(account.getId(), accountDTO.getId());
        assertEquals(account.getBalance(), accountDTO.getBalance());
        assertEquals(account.getCreationDate(), accountDTO.getCreationDate());
    }

    @Test
    void testConvertCustomerEntityToCustomerDTO() {
        Customer customer = TestUtil.createCustomer();
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

        assertEquals(customer.getId(), customerDTO.getId());
        assertEquals(customer.getName(), customerDTO.getName());
        assertEquals(customer.getSurname(), customerDTO.getSurname());
        assertEquals(customer.getBalance(), customerDTO.getBalance());
    }
}