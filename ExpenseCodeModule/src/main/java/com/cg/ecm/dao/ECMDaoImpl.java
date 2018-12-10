package com.cg.ecm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.ecm.entity.ExpenseDetails;
import com.cg.ecm.exception.ECMException;
import com.cg.ecm.repository.ExpenseRepository;

@Repository
public class ECMDaoImpl implements EMCDao {

	@Autowired
	private ExpenseRepository repository;

	@Override
	public ExpenseDetails addDetails(ExpenseDetails expdetails)
			throws ECMException {
		ExpenseDetails detail = getByCode(expdetails.getExpenseCode());
		if (detail == null) {
			repository.save(expdetails);
		} else {
			throw new ECMException("ExpenseCode already exists");
		}
		return expdetails;
	}

	@Override
	public List<ExpenseDetails> getAllDetails() throws ECMException {
		List<ExpenseDetails> list = repository.findAll();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ECMException("NO DATA TO DISPLAY!!");
		}

	}

	@Override
	public ExpenseDetails getByCode(String expenseCode) {
		 repository.findOne(expenseCode);
		return null;
	}

	@Override
	public ExpenseDetails DeleteByCode(String expenseCode) {
		ExpenseDetails detail = getByCode(expenseCode);
		if (detail != null) {
			repository.delete(detail);
		}
		return detail;

	}

	@Override
	public ExpenseDetails updateDetails(ExpenseDetails expdetails)
			throws ECMException {
		ExpenseDetails detail = getByCode(expdetails.getExpenseCode());
		if (detail != null) {
			repository.save(expdetails);
		} else {
			throw new ECMException("Nothing to modify");
		}
		return expdetails;
	}

}
