package com.divergentsl.cms.service;

import java.util.List;

import com.divergentsl.cms.entity.Drug;

public interface DrugService {

public void add(int drugId, String name, String description);
	
	public Drug search(int drugId);
	
	public List<Drug> listAll();
	
	public boolean delete(int drugId);
	
	public void update(Drug drug);
	
}
