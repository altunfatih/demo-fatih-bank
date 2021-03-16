package com.fatih.bank.db.model.enumaration;

public enum CustomerStatusType {

    ACTIVE,
    INACTIVE,
    UNAPPROVED;
    
    public static CustomerStatusType fromStr(String status) {
        return CustomerStatusType.valueOf(status.toUpperCase());
    }
}