package com.account.api.service;

import com.account.api.enums.TransactionType;
import com.account.api.model.Account;
import com.account.api.model.CreateAccountRequest;
import com.account.api.model.Customer;
import com.account.api.model.Transaction;
import com.account.api.repository.AccountRepository;
import com.account.api.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;

    @PersistenceContext
    private EntityManager entityManager;

    public AccountService(AccountRepository accountRepository, TransactionService transactionService, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
        this.customerService = customerService;
    }

    public Account createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        // Create a new account attached to the current user
        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                DateUtil.getCurrentInstant());
        Account accountSaved = accountRepository.saveAndFlush(account);

        // Based on initial amount value:
        // If initial amount is not 0: Update balance of current user and create new transaction of type TRANSFER attached to the newly created account
        // If initial amount is equals to 0: No transaction will be created
        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            customer.setBalance(customer.getBalance().add(createAccountRequest.getInitialCredit()));
            customerService.updateCustomer(customer);

            TransactionType transactionType = TransactionType.TRANSFER;
            Transaction transaction = new Transaction(
                    createAccountRequest.getInitialCredit(),
                    DateUtil.getCurrentInstant(),
                    accountSaved,
                    transactionType);
            transactionService.saveTransaction(transaction);
        }

        return accountSaved;
    }
}
