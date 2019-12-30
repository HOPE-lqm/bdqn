package com.bank.dao;

import java.sql.Connection;

import com.bank.entity.Account;

public interface AccountDao {

	/**
	 * ���ݿ��Ų�ѯ�˻���Ϣ
	 * 
	 * @param cardNo ����
	 * @return
	 */
	public Account getAccountByCardNo(String cardNo);
	
	
	public int  updateInAccount(String cardNo ,double money,Connection conn);
	
	public int  updateOutAccount(String cardNo ,double money,Connection conn);
	
	
}
