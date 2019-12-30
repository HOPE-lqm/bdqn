package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.service.TransactionRecordService;
import com.bank.service.impl.TransactionRecordServiceImpl;

public class CheckTransactionRecordServlet extends HttpServlet {

	TransactionRecordService service = new TransactionRecordServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 火获取请求的数据
		String incardNo = req.getParameter("incardNo");
		String outcardNo = req.getSession().getAttribute("cardno").toString();
		double money = Double.parseDouble(req.getParameter("inmoney"));
		int result = service.checkTransactionBeforeService(incardNo, outcardNo, money);
		PrintWriter out = resp.getWriter();
		out.print(result);

	}

}
