package com.bank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.Account;
import com.bank.entity.TransactionRecord;
import com.bank.service.TransactionRecordService;
import com.bank.service.TransactionService;
import com.bank.service.impl.TransactionRecordServiceImpl;
import com.bank.service.impl.TransactionServiceImpl;

public class TransactionRecordServlet extends HttpServlet {

	TransactionRecordService service = new TransactionRecordServiceImpl();
	TransactionService trService = new TransactionServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求数据
		String incardNo = req.getParameter("incardNo");
		String outcardNo = req.getSession().getAttribute("cardno").toString();
		double inmoney = Double.parseDouble(req.getParameter("inmoney"));
		//转入账户
		TransactionRecord inTr = new TransactionRecord();
		Account inAc = new Account();
		inAc.setCardno(incardNo);
		inTr.setAccount(inAc);
		inTr.setExpense(0);
		inTr.setIncome(inmoney);
		inTr.setBalance(service.getAccountBalance(incardNo) + inmoney);
		inTr.setTransactionType("转入");
		
		//转出账户
		TransactionRecord outTr = new TransactionRecord();
		Account outAc = new Account();
		outAc.setCardno(outcardNo);
		outTr.setAccount(outAc);
		outTr.setExpense(inmoney);
		outTr.setIncome(0);
		outTr.setBalance(service.getAccountBalance(outcardNo) - inmoney);
		outTr.setTransactionType("转出");
		int row = trService.transactionRecord(inTr, outTr, inmoney);
		resp.getWriter().print(row);
	}

}
