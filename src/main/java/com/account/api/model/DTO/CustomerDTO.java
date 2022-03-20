package com.account.api.model.DTO;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public class CustomerDTO {

    private UUID id;
    private String name;
    private String surname;
    private BigDecimal balance = BigDecimal.ZERO;
    private Set<AccountDTO> accounts;

    public CustomerDTO() {}

    public CustomerDTO(UUID id, String name, String surname, BigDecimal balance, Set<AccountDTO> accounts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.accounts = accounts;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountDTO> accounts) {
        this.accounts = accounts;
    }
}
