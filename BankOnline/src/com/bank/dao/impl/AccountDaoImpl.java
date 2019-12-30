package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.dao.AccountDao;
import com.bank.dao.BaseDao;
import com.bank.entity.Account;

public class AccountDaoImpl extends BaseDao implements AccountDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	@Override
	public Account getAccountByCardNo(String cardNo) {
		Account account = null;
		try {
			conn = this.getConnection();
			String sql = "select * from account where cardno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cardNo);
			rs = psmt.executeQuery();
			while (rs.next()) {
				account = new Account();
				account.setCardno(rs.getString("cardno"));
				account.setPassword(rs.getString("password"));
				account.setBalance(rs.getDouble("balance"));
				account.setStatus(rs.getInt("status"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return account;
	}

	@Override
	public int updateInAccount(String cardNo, double money, Connection conn) {
		int row = 0;
		try {
			String sql = "UPDATE `account` SET `balance` = `balance` + ? WHERE `cardno` = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setDouble(1, money);
			psmt.setString(2, cardNo);
			row = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(null, psmt, rs);
		}
		return row;
	}

	@Override
	public int updateOutAccount(String cardNo, double money, Connection conn) {
		int row = 0;
		try {
			String sql = "UPDATE `account` SET `balance` = `balance` - ? WHERE `cardno` = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setDouble(1, money);
			psmt.setString(2, cardNo);
			row = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(null, psmt, rs);
		}
		return row;
	}

}
