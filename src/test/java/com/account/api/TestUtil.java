package com.account.api;

import com.account.api.constant.Constants;
import com.account.api.enums.TransactionType;
import com.account.api.model.Account;
import com.account.api.model.CreateAccountRequest;
import com.account.api.model.Customer;
import com.account.api.model.DTO.AccountDTO;
import com.account.api.model.DTO.CustomerDTO;
import com.account.api.model.Transaction;
import com.account.api.util.DateUtil;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.UUID;

public class TestUtil {

    public static Account createAccount() {
        Account account = new Account(createCustomer(), BigDecimal.ZERO, DateUtil.getCurrentInstant());
        account.setId(UUID.fromString(Constants.Account.ACCOUNT_UUID));
        return account;
    }

    public static AccountDTO createAccountDTO() {
        AccountDTO accountDTO = new AccountDTO(UUID.fromString(Constants.Account.ACCOUNT_UUID), BigDecimal.ZERO, DateUtil.getCurrentInstant(), Collections.emptySet());
        accountDTO.setId(UUID.fromString(Constants.Account.ACCOUNT_UUID));
        return accountDTO;
    }

    public static Customer createCustomer() {
        Customer customer = new Customer(Constants.Customer.CUSTOMER_NAME_JOHN, Constants.Customer.CUSTOMER_SURNAME_DOE);
        customer.setId(UUID.fromString(Constants.Customer.CUSTOMER_UUID));
        return customer;
    }

    public static CustomerDTO createCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO(UUID.fromString(Constants.Customer.CUSTOMER_UUID), Constants.Customer.CUSTOMER_NAME_JOHN, Constants.Customer.CUSTOMER_SURNAME_DOE, BigDecimal.ZERO, Collections.emptySet());
        customerDTO.setId(UUID.fromString(Constants.Customer.CUSTOMER_UUID));
        return customerDTO;
    }

    public static Transaction createTransaction(Account account) {
        Transaction transaction = new Transaction(BigDecimal.ZERO, DateUtil.getCurrentInstant(), account, TransactionType.TRANSFER);
        transaction.setId(UUID.fromString(Constants.Transaction.TRANSACTION_UUID));
        return transaction;
    }

    public static CreateAccountRequest createAccountRequest() {
        return new CreateAccountRequest(UUID.fromString(Constants.Customer.CUSTOMER_UUID), BigDecimal.valueOf(100L));
    }
}
