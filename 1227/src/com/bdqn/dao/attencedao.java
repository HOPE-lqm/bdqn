package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.attence;

public interface attencedao {
	public List<attence> getriskgrade(String name);
	
	public int datele(int id);
	
	public int into(String empname,String dept,String chkdate,int status);
	
	public List<attence> selectid(int id);
	
	public int xg(int id,String empname,String dept,String chkdate,int status);
}
