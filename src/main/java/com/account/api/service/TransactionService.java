package com.account.api.service;

import com.account.api.model.Transaction;
import com.account.api.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.saveAndFlush(transaction);
    }
}
