package com.fatih.bank.api.helper;

public class AccountNumberGenerator {

    public static String generateAccountNumber(Long customerId, int existingAccountCount) {
        if(customerId == null) {
            throw new RuntimeException("Customer Id cannot be null");
        }
        return String.format("%07d-%02d", customerId, existingAccountCount+1 );
    }
}
