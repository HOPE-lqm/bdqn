package com.bank.service.impl;

import com.bank.dao.AccountDao;
import com.bank.dao.impl.AccountDaoImpl;
import com.bank.entity.Account;
import com.bank.service.TransactionRecordService;

public class TransactionRecordServiceImpl implements TransactionRecordService {

	AccountDao dao = new AccountDaoImpl();

	@Override
	public int checkTransactionBeforeService(String inCardNo, String outCardNo, double money) {
		int result = 0;
		// 获取转入账户的信息
		Account inAccout = dao.getAccountByCardNo(inCardNo);
		// 获取转出账户的信息
		Account outAccount = dao.getAccountByCardNo(outCardNo);
		if (inAccout == null) {
			result = 1;
		} else {
			if (inAccout.getStatus() == 0) {
				result = 3;
			} else if (outAccount.getBalance() < money) {
				result = 4;
			}
		}
		return result;
	}

	@Override
	public double getAccountBalance(String cardNo) {
		Account ac = dao.getAccountByCardNo(cardNo);
		return ac.getBalance();
	}

}
