package com.cg.pcm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "MyProject")
public class Project {
	
	@Id
	/*@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_code")*/
	private String projectCode;
	
	/*@Pattern(regexp = "[A-Z]{1}[A-Za-z+\\s]{2,}")
	@Column(name = "project_description")*/
	private String projectDescription;
	
	@Column(name = "start_date")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	
	@Column(name = "end_date")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date endDate;

	public String getProductCode() {
		return projectCode;
	}

	public void setProductCode(String productCode) {
		this.projectCode = productCode;
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
		this.projectCode = productCode;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Project() {
	}

}
