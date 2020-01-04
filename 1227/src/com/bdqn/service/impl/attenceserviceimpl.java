package com.bdqn.service.impl;

import java.util.List;

import com.bdqn.dao.attencedao;
import com.bdqn.dao.impl.attencedaoimpl;
import com.bdqn.entity.attence;
import com.bdqn.service.attenceservice;

public class attenceserviceimpl implements attenceservice {
	attencedao dao = new attencedaoimpl();
	@Override
	public List<attence> getriskgrade(String name) {
		return dao.getriskgrade(name);
	}

	@Override
	public int datele(int id) {
		// TODO Auto-generated method stub
		return dao.datele(id);
	}

	@Override
	public int into(String empname, String dept, String chkdate, int status) {
		// TODO Auto-generated method stub
		return dao.into(empname, dept, chkdate, status);
	}

	@Override
	public List<attence> selectid(int id) {
		// TODO Auto-generated method stub
		return dao.selectid(id);
	}

	@Override
	public int xg(int id, String empname, String dept, String chkdate, int status) {
		// TODO Auto-generated method stub
		return dao.xg(id, empname, dept, chkdate, status);
	}

}
