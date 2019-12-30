package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.service.LoginService;
import com.bank.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {

	LoginService service = new LoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡ���������
		String cardNo = req.getParameter("cardno");
		String password = req.getParameter("password");
		// ����ҵ���߼���
		int result = service.login(cardNo, password);
		req.getSession().setAttribute("cardno", cardNo);
		// ��Ӧ���
		PrintWriter out = resp.getWriter();
		out.print(result);
	}

}
