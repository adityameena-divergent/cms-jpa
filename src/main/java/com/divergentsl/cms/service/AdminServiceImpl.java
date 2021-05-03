package com.divergentsl.cms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.AdminDao;
import com.divergentsl.cms.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Transactional
	@Override
	public boolean login(String username, String password) {
		Admin admin = adminDao.find(username);
		
		if (admin != null && admin.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
