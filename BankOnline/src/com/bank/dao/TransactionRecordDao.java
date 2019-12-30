package com.bank.dao;

import java.sql.Connection;

import com.bank.entity.TransactionRecord;

public interface TransactionRecordDao {

	public int addTransactionRecord(TransactionRecord tr, Connection conn);

}
