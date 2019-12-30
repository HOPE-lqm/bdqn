package com.bank.dao;

import java.sql.Connection;

import com.bank.entity.Account;

public interface AccountDao {

	/**
	 * 根据卡号查询账户信息
	 * 
	 * @param cardNo 卡号
	 * @return
	 */
	public Account getAccountByCardNo(String cardNo);
	
	
	public int  updateInAccount(String cardNo ,double money,Connection conn);
	
	public int  updateOutAccount(String cardNo ,double money,Connection conn);
	
	
}
