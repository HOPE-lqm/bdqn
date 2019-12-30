package com.bank.service;

import com.bank.entity.TransactionRecord;

public interface TransactionService {
	
	public int transactionRecord(TransactionRecord inTr,TransactionRecord outTr,double money);
	
	
}
