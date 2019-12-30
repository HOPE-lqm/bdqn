package com.bank.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.bank.dao.AccountDao;
import com.bank.dao.BaseDao;
import com.bank.dao.TransactionRecordDao;
import com.bank.dao.impl.AccountDaoImpl;
import com.bank.dao.impl.TransactionRecordDaoImpl;
import com.bank.entity.TransactionRecord;
import com.bank.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
	TransactionRecordDao dao = new TransactionRecordDaoImpl();
	AccountDao acDao = new AccountDaoImpl();
	BaseDao bd = new BaseDao();

	@Override
	public int transactionRecord(TransactionRecord inTr, TransactionRecord outTr, double money) {
		Connection conn = bd.getConnection();
		int row = 0;
		try {
			conn.setAutoCommit(false);
			acDao.updateInAccount(inTr.getAccount().getCardno(), money, conn);
			acDao.updateOutAccount(outTr.getAccount().getCardno(), money, conn);
			dao.addTransactionRecord(inTr, conn);
			//int i = 10 / 0;
			row = dao.addTransactionRecord(outTr, conn);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}

}
