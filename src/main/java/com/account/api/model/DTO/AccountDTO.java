package com.account.api.model.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class AccountDTO {

    private UUID id;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private Set<TransactionDTO> transactions;

    public AccountDTO() {}

    public AccountDTO(UUID id, BigDecimal balance, LocalDateTime creationDate, Set<TransactionDTO> transactions) {
        this.id = id;
        this.balance = balance;
        this.creationDate = creationDate;
        this.transactions = transactions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Set<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
}
