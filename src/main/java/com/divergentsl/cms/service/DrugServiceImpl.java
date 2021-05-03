package com.divergentsl.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.cms.dao.DrugDao;
import com.divergentsl.cms.entity.Drug;

@Service
public class DrugServiceImpl implements DrugService {
	
	
	@Autowired
	private DrugDao drugDao;
	
	@Transactional
	@Override
	public void add(int drugId, String name, String description) {

		Drug drug = new Drug();
		
		drug.setId(drugId);
		drug.setName(name);
		drug.setDescription(description);
		this.drugDao.add(drug);
	}

	@Transactional
	@Override
	public Drug search(int drugId) {
		return this.drugDao.searchById(drugId);
	}

	@Transactional
	@Override
	public List<Drug> listAll() {		
		return this.drugDao.listAll();
	}

	@Transactional
	@Override
	public boolean delete(int drugId) {
		Drug drug = this.search(drugId);
		if(drug != null) {
			this.drugDao.delete(drug);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public void update(Drug drug) {
		this.drugDao.update(drug);
	}

	

}
