package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.dao.BaseDao;
import com.bank.dao.TransactionRecordDao;
import com.bank.entity.TransactionRecord;

public class TransactionRecordDaoImpl extends BaseDao implements TransactionRecordDao {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	@Override
	public int addTransactionRecord(TransactionRecord tr, Connection conn) {
		int row = 0;
		try {
			String sql = "INSERT INTO `transaction_record`(`cardno`,`transaction_date`,`expense`,`income`,`balance`,`transaction_type`)VALUES(?,NOW(),?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, tr.getAccount().getCardno());
			psmt.setDouble(2, tr.getExpense());
			psmt.setDouble(3, tr.getIncome());
			psmt.setDouble(4, tr.getBalance());
			psmt.setString(5, tr.getTransactionType());

			row = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(null, psmt, rs);
		}
		return row;
	}

}
