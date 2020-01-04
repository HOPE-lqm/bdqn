package com.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.entity.attence;
import com.bdqn.service.attenceservice;
import com.bdqn.service.impl.attenceserviceimpl;

public class mainservlet extends HttpServlet {
	attenceservice fin = new attenceserviceimpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = "";
		if(req.getParameter("chk_option") != null ) {
			name = req.getParameter("chk_option");
			System.out.println(name);
		}
		List<attence> list = fin.getriskgrade(name);
		req.setAttribute("list", list);

		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}
