package com.fatih.bank.db.dao;

import java.util.List;

import com.fatih.bank.db.model.TransactionLog;

public interface TransactionLogDao {

    List<TransactionLog> findByAccountId(Long accountId);

    void save(TransactionLog transactionLog);

}