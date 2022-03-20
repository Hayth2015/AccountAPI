package com.account.api.model;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateAccountRequest {

    public CreateAccountRequest() {
    }

    public CreateAccountRequest(UUID customerId, BigDecimal initialCredit) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
    }

    private UUID customerId;
    private BigDecimal initialCredit;

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(BigDecimal initialCredit) {
        this.initialCredit = initialCredit;
    }
}
