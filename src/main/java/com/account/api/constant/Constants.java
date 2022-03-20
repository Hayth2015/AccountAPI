package com.account.api.constant;

public final class Constants {

    /**
     * This private constructor prevents
     * the instantiation of this class directly
     */
    private Constants () {}

    /**
     * Constants for Customer
     */
    public static final class Customer{
        private Customer() {}

        public static final String CUSTOMER_UUID = "19cf2403-10d7-4a89-b612-b4b399b3a639";
        public static final String CUSTOMER_NAME_JOHN = "John";
        public static final String CUSTOMER_NAME_JANE = "Jane";
        public static final String CUSTOMER_SURNAME_DOE = "Doe";
    }

    public static final class Account {
        private Account() {}

        public static final String ACCOUNT_UUID = "0db5a1c4-14e4-4813-b693-81f8b7258e22";
    }

    public static final class Transaction {
        private Transaction() {}

        public static final String TRANSACTION_UUID = "3fa85f64-5717-4562-b3fc-2c963f66afa6";
    }
}
