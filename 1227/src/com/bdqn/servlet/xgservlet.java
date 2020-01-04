package com.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.service.attenceservice;
import com.bdqn.service.impl.attenceserviceimpl;

public class xgservlet extends HttpServlet {
	attenceservice fin = new attenceserviceimpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String sy = req.getParameter("sy");
		String qs = req.getParameter("qs");
		int jz = Integer.parseInt(req.getParameter("jz"));
		int idf = Integer.parseInt(req.getParameter("idf"));
		int jg = fin.xg(idf,id, sy, qs, jz);
		PrintWriter out = resp.getWriter();
		out.print(jg);
	}
} 
