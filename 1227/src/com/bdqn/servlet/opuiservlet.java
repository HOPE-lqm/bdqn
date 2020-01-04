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

public class opuiservlet extends HttpServlet {
	attenceservice fin = new attenceserviceimpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		List<attence> list = fin.selectid(id);
		req.setAttribute("list", list);

		req.getRequestDispatcher("opui.jsp").forward(req, resp);
	}
}
