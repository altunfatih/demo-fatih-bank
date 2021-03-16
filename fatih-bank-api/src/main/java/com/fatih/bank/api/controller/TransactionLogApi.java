package com.fatih.bank.api.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatih.bank.api.dto.TransactionLogDto;
import com.fatih.bank.db.dao.TransactionLogDao;
import com.fatih.bank.db.model.TransactionLog;

@RestController
@RequestMapping(TransactionLogApi.API_TRANSACTION_BASE_URL)
public class TransactionLogApi {

	static final String API_TRANSACTION_BASE_URL = "/api/transaction";

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TransactionLogDao transactionLogDao;

	@GetMapping("/list")
	public List<TransactionLogDto> listAll(Long accountId) {

		List<TransactionLog> transactionLogs = transactionLogDao.findByAccountId(accountId);

		List<TransactionLogDto> resultList = new ArrayList<>();
		for (TransactionLog transactionLog : transactionLogs) {
			TransactionLogDto convertedDto = modelMapper.map(transactionLog, TransactionLogDto.class);
			resultList.add(convertedDto);
		}

		return resultList;
	}

	@PostMapping("/transfer")
	public TransactionLogDto transfer(Long accountId, String toAccountNumber, BigDecimal amount) {

		TransactionLog transactionLog = new TransactionLog();
		transactionLog.setAmount(amount);

		// TODO

		transactionLogDao.save(transactionLog);

		return null;
	}

	@PostMapping("/withdraw")
	public TransactionLogDto withdraw(Long accountId, BigDecimal amount) {
		return null;
	}

	@PostMapping("/deposit")
	public TransactionLogDto deposit(Long accountId, BigDecimal amount) {
		return null;
	}
}