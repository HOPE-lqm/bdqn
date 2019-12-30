package com.bank.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {

	/**
	 * 使用连接池方式进行数据库的连接
	 * 
	 * @return 连接对象
	 */
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/bankonline");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放连接资源对象
	 * 
	 * @param conn
	 * @param psmt
	 * @param rs
	 */
	public void closeAll(Connection conn, PreparedStatement psmt, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}

			if (psmt != null) {
				psmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行 增加 ，修改 ，删除的数据库操作
	 * 
	 * @param sql
	 *            执行的sql
	 * @param params
	 *            参数
	 * @return 结果
	 */
	public int executeUpdate(String sql, Object[] params) {
		int row = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = this.getConnection();
			psmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				psmt.setObject(i + 1, params[i]);
			}
			row = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, null);
		}
		return row;
	}

}
