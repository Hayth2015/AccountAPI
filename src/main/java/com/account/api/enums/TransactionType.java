package com.account.api.enums;

public enum TransactionType {

    TRANSFER("transfer");

    private final String label;

    TransactionType(final String label) {this.label = label;}

    public String getLabel() {
        return label;
    }

    public static TransactionType fromValue(final String value) {
        for (final TransactionType transactionType : TransactionType.values()) {
            if (String.valueOf(transactionType.label).equals(value)) {
                return transactionType;
            }
        }
        return null;
    }
}
