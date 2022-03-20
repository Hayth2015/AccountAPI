package com.account.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private UUID id;

    private BigDecimal balance;

    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    public Account() {}

    /**
     * Constructor for Account object
     * @param customer the associated {@link Customer}
     * @param balance a {@link BigDecimal} number representing the initial amount of the account
     * @param creationDate the date of creation of the account
     */
    public Account(Customer customer, BigDecimal balance, LocalDateTime creationDate) {
        this.customer = customer;
        this.balance = balance;
        this.creationDate = creationDate;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transaction) {
        this.transactions = transaction;
    }
}
