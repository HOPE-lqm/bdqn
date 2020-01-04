package com.bdqn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	/**
	 * ��ȡ���ݿ����Ӷ���
	 */
	public Connection getConnection() {
		Context ctx;
		// ��ȡ���Ӳ������쳣
		try {
			ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/bdqn");
			conn=ds.getConnection();		
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return conn;
	}
	/**
	 * �ر����ݿ����ӡ�
	 * @param conn ���ݿ�����
	 * @param stmt Statement����
	 * @param rs �����
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// �����������Ϊ�գ���ر�
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ��Statement����Ϊ�գ���ر�
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// �����ݿ����Ӷ���Ϊ�գ���ر�
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ����ɾ���Ĳ���
	 * @param sql sql���
	 * @param prams ��������
	 * @return ִ�н��
	 */
	public int exceuteUpdate(String sql,Object...prams){
		int result=0;
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<prams.length;i++){
				pstmt.setObject(i+1, prams[i]);	
			}
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(conn, pstmt, rs);
		}
		return result;
	}
}
