package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.TransactionLogRepository;

public class TransactionLogServiceImpl implements TransactionLogService{

	@Autowired
	private TransactionLogRepository transactionLogRepository;
	@Override
	public List<TransactionLog> findAll() {
		
		return transactionLogRepository.findAll();
	}

}
