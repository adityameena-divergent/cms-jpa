package com.divergentsl.cms.dao;

import java.util.List;

import com.divergentsl.cms.entity.Drug;

public interface DrugDao {

public void add(Drug drug);
	
	public Drug searchById(int drugId);
	
	public List<Drug> listAll();
	
	public void delete(Drug drug);
	
	public void update(Drug drug);
	
}
