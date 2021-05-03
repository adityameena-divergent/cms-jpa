package com.divergentsl.cms.dao;

import java.util.List;

import com.divergentsl.cms.entity.LabTest;

public interface LabTestDao {

public void add(LabTest labTest);
	
	public LabTest searchById(int labTestId);
	
	public List<LabTest> listAll();
	
	public void delete(LabTest labTest);
	
	public void update(LabTest labTest);
	
}
