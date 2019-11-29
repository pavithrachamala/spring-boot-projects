package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;

public interface TransactionService {
	public List<AccountTransaction> findAll();
	public List<AccountTransaction> findByAccountAccountNumber(Long accountNumber);
	

}
