package com.bankapp.web.bean.config;

public class DepositeOrWithdrawRequest {
	private Long accountNumber;
	private Double amount;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}
