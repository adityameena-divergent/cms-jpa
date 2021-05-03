package com.divergentsl.cms.service;

import java.util.List;

import com.divergentsl.cms.entity.LabTest;

public interface LabTestService {

	
public void add(int labTestId, String testName, int fee);
	
	public LabTest search(int labTestId);
	
	public List<LabTest> listAll();
	
	public boolean delete(int labTestId);
	
	public void update(LabTest labTest);
	
	
}
