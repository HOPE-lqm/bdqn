package com.bank.service.impl;

import com.bank.dao.AccountDao;
import com.bank.dao.impl.AccountDaoImpl;
import com.bank.entity.Account;
import com.bank.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	AccountDao dao = new AccountDaoImpl();
	
	@Override
	public int login(String cardNo,String password) {
		int result = 0;
		Account account = dao.getAccountByCardNo(cardNo);
		if(account == null) {
			result = 1;
		}else {
			if(!account.getPassword().equals(password)) {
				result = 2;
			}else if(account.getStatus() == 0) {
				result = 3;
			}
		}
		return result;
	}

}
