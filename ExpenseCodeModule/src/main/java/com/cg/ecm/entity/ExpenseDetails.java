package com.cg.ecm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "MyExpense")
public class ExpenseDetails {
	
	@Id
	private String expenseCode;

	@NotNull
	@Size(min=3,max=15, message="Name should have atleast 3 characters")
	private String expenseType;

	@NotNull
	@Size(min=15,max=100, message="Name should have atleast 15 characters")
	private String expenseDescription;
	
	
	public String getExpenseCode() {
		return expenseCode;
	}
	public void setExpenseCode(String expenseCode) {
		this.expenseCode = expenseCode;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseDescription() {
		return expenseDescription;
	}
	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
	@Override
	public String toString() {
		return "ExpenseDetails [expenseCode=" + expenseCode + ", expenseType="
				+ expenseType + ", expenseDescription=" + expenseDescription
				+ "]";
	}
	public ExpenseDetails(String expenseCode, String expenseType,
			String expenseDescription) {
		super();
		this.expenseCode = expenseCode;
		this.expenseType = expenseType;
		this.expenseDescription = expenseDescription;
	}
	public ExpenseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
