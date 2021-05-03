package com.divergentsl.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.LabTestDao;
import com.divergentsl.cms.entity.LabTest;

@Service
public class LabTestServiceImpl implements LabTestService {

	
	@Autowired
	private LabTestDao labTestDao;
	
	@Transactional
	@Override
	public void add(int labTestId, String labTestName, int fee) {

		LabTest labTest = new LabTest();
		
		labTest.setTestId(labTestId);
		labTest.setTestName(labTestName);
		labTest.setTestFee(fee);
		this.labTestDao.add(labTest);
	}

	@Transactional
	@Override
	public LabTest search(int labTestId) {
		return this.labTestDao.searchById(labTestId);
	}

	@Transactional
	@Override
	public List<LabTest> listAll() {		
		return this.labTestDao.listAll();
	}

	@Transactional
	@Override
	public boolean delete(int labTestId) {
		LabTest labTest = this.search(labTestId);
		if(labTest != null) {
			this.labTestDao.delete(labTest);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public void update(LabTest labTest) {
		this.labTestDao.update(labTest);
	}

	
}
