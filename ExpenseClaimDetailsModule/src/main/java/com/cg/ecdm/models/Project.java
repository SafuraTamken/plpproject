package com.cg.ecdm.models;

import java.util.Date;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;



public class Project {
	

	private String productCode;
	

	private String projectDescription;
	

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date endDate;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Project(String productCode, String projectDescription,
			Date startDate, Date endDate) {
		super();
		this.productCode = productCode;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Project() {
	}

}
