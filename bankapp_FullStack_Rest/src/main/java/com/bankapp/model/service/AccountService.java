package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;

public interface AccountService {
	public List<Account> findAll();
	public Account findByAccountNumber(Long accountNumber);
	public void deleteAccount(Long accountNumber);
	public void updateAccount(Account account,Long accountNumber);
	void blockAccount(Long accountNumber);
    void createAccount(Account account );
    void deposit(Long accountNumber, double amount,String authority);
    void withdraw(Long accountNumber, double amount,String authority);
    void transfer(Long fromAccNumber, Long toAccNumber, double amount,String authority);
   
}
