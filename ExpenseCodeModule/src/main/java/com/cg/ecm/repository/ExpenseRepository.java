package com.cg.ecm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ecm.entity.ExpenseDetails;

public interface ExpenseRepository extends JpaRepository<ExpenseDetails, String>{

}
