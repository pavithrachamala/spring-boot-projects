package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.repo.AccountTransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private AccountTransactionRepository repo;

	@Override
	public List<AccountTransaction> findAll() {
		
		return repo.findAll();
	}

	@Override
	public List<AccountTransaction> findByAccountAccountNumber(Long accountNumber) {
		
		return repo.findByAccountAccountNumber(accountNumber);
	}

}

