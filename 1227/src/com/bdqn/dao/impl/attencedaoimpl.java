package com.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.attencedao;
import com.bdqn.entity.attence;

public class attencedaoimpl extends BaseDao implements attencedao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	@Override
	public List<attence> getriskgrade(String name) {
		List<attence> list = new ArrayList<attence>();
		try {
			conn = this.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from attence");	
			if(name != null || "".equals(name)) {
				sql.append(" where empname like concat('%',?,'%')");
			}
			psmt = conn.prepareStatement(sql.toString());
			if(name != null || "".equals(name)) {
				psmt.setString(1, name);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				attence fin = new attence();
				fin.setId(rs.getInt("id"));
				fin.setEmpname(rs.getString("empname"));
				fin.setDept(rs.getString("dept"));
				fin.setChkdate(rs.getString("chkdate"));
				fin.setStatus(rs.getInt("status"));
				list.add(fin);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return list;
	}

	@Override
	public int datele(int id) {
		int row = 0;
		try {
			conn = this.getConnection();
			String sql = "delete from attence where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			row = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return row;
	}

	@Override
	public int into(String empname, String dept, String chkdate, int status) {
		int row = 0;
		try {
			conn = this.getConnection();
			String sql = "insert into attence(empname,dept,chkdate,status) value(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, empname);
			psmt.setString(2, dept);
			psmt.setString(3, chkdate);
			psmt.setInt(4, status);
			row = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return row;
	}

	@Override
	public List<attence> selectid(int id) {
		List<attence> list = new ArrayList<attence>();
		try {
			conn = this.getConnection();
			String sql = "select * from attence where id = ?";			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				attence fin = new attence();
				fin.setId(rs.getInt("id"));
				fin.setEmpname(rs.getString("empname"));
				fin.setDept(rs.getString("dept"));
				fin.setChkdate(rs.getString("chkdate"));
				fin.setStatus(rs.getInt("status"));
				list.add(fin);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return list;
	}

	@Override
	public int xg(int id, String empname, String dept, String chkdate, int status) {
		int row = 0;
		try {
			conn = this.getConnection();
			String sql = "update attence set empname=?,dept=?,chkdate=?,status=? where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, empname);
			psmt.setString(2, dept);
			psmt.setString(3, chkdate);
			psmt.setInt(4, status);
			psmt.setInt(5, id);
			row = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return row;
	}



}
