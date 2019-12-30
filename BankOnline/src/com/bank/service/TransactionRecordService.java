package com.bank.service;

public interface TransactionRecordService {

	/**
	 * ת��ҵ��ļ��
	 * 
	 * @param inCardNo
	 *            ת���˻�
	 * @param outCardNo
	 *            ת���˻�
	 * @param money
	 *            ���׽��
	 * @return ���
	 */
	public int checkTransactionBeforeService(String inCardNo, String outCardNo, double money);
	
	public double getAccountBalance(String cardNo);
	
}
