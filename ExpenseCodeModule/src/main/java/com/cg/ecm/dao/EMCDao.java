package com.cg.ecm.dao;

import java.util.List;

import com.cg.ecm.entity.ExpenseDetails;
import com.cg.ecm.exception.ECMException;

public interface EMCDao {

	ExpenseDetails addDetails(ExpenseDetails expdetails) throws ECMException;

	List<ExpenseDetails> getAllDetails() throws ECMException;

	ExpenseDetails getByCode(String expenseCode);

	ExpenseDetails DeleteByCode(String expenseCode);

	ExpenseDetails updateDetails(ExpenseDetails expdetails) throws ECMException;

}
