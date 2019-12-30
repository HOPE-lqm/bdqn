package com.bank.service;

public interface TransactionRecordService {

	/**
	 * 转账业务的检查
	 * 
	 * @param inCardNo
	 *            转入账户
	 * @param outCardNo
	 *            转出账户
	 * @param money
	 *            交易金额
	 * @return 结果
	 */
	public int checkTransactionBeforeService(String inCardNo, String outCardNo, double money);
	
	public double getAccountBalance(String cardNo);
	
}
