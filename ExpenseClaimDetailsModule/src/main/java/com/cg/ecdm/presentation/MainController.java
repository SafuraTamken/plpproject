package com.cg.ecdm.presentation;

import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cg.ecdm.models.Employee;
import com.cg.ecdm.models.ExpenseDetails;
import com.cg.ecdm.models.Project;

@RestController
@RequestMapping("/ecdm")
public class MainController {

	@RequestMapping(value = "/createExpense", method = RequestMethod.POST)
	public ExpenseDetails createExpense(
			@RequestBody ExpenseDetails expenseDetails) {
		final String uri = "http://ExpenseCodeModule/expense/create";
		RestTemplate restTemplate = new RestTemplate();
		ExpenseDetails details = restTemplate.postForObject(uri,
				expenseDetails, ExpenseDetails.class);
		return details;
	}
	
	@RequestMapping(value = "/readExpense", method = RequestMethod.GET)
	public List<ExpenseDetails> readExpense() {
		final String uri = "http://ExpenseCodeModule/expense/readExpense";
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<ExpenseDetails> details = restTemplate.getForObject(uri, List.class);
		return details;
	}
	
	@RequestMapping(value = "/readExpense/{expenseCode}", method = RequestMethod.GET)
	public ExpenseDetails readByExpenseCode(@PathVariable String expenseCode) {
		final String uri = "http://ExpenseCodeModule/expense/read/{expenseCode}";
		RestTemplate restTemplate = new RestTemplate();
		ExpenseDetails details = restTemplate.getForObject(uri, ExpenseDetails.class, expenseCode);
		return details;
	}
	
	@RequestMapping(value = "/modifyExpense/{expenseCode}", method = RequestMethod.PUT)
	public ExpenseDetails modifyExpense(@PathVariable String expenseCode,
			@RequestBody ExpenseDetails expenseDetails) {
		final String uri = "http://ExpenseCodeModule/expense/update/{expenseCode}";
		RestTemplate restTemplate = new RestTemplate();
		expenseDetails.setExpenseCode(expenseCode);
		restTemplate.put(uri, expenseDetails, expenseCode);
		return expenseDetails;
	}
	
	@RequestMapping(value = "/deleteExpense/{expenseCode}", method = RequestMethod.DELETE)
	public String deleteExpense(
			@PathVariable String expenseCode) {
		final String uri = "http://ExpenseCodeModule/expense/delete/{expenseCode}";
		RestTemplate restTemplate = new RestTemplate();
	restTemplate.delete(uri,	expenseCode);
		return "Delete Success";
	}
	

	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		final String uri = "http://localhost:8884/employee/create";
		RestTemplate restTemplate = new RestTemplate();
		Employee details = restTemplate.postForObject(uri, employee,
				Employee.class);
		return details;
	}

	@RequestMapping(value = "/readEmployee", method = RequestMethod.GET)
	public List<Employee> readEmployee() {
		final String uri = "http://localhost:8884/employee/readall";
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<Employee> details = restTemplate.getForObject(uri, List.class);
		return details;
	}

	@RequestMapping(value = "/modifyEmployee/{employeeId}", method = RequestMethod.PUT)
	public Employee updateData(@PathVariable String employeeId,
			@RequestBody Employee employee) {
		final String uri = "http://localhost:8884/employee/modify/{employeeId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, employee, employeeId);
		return employee;

	}

	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.DELETE)
	public String deleteData(@PathVariable String employeeId) {
		final String uri = "http://localhost:8884/employee/delete/{employeeId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, employeeId);
		return " happy??? deleted :-(";

	}

	@RequestMapping(value = "/readEmployee/{employeeId}", method = RequestMethod.GET)
	public Employee readData(@PathVariable String employeeId) {
		final String uri = "http://localhost:8884/employee/read/{employeeId}";
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(uri, Employee.class, employeeId);
		return employee;
	}
	
	@RequestMapping(value = "/createProject", method = RequestMethod.POST)
	public Project createProject(@RequestBody Project project) {
		final String uri = "http://localhost:8883/project/insert";
		RestTemplate restTemplate = new RestTemplate();
		Project details = restTemplate.postForObject(uri, project,
				Project.class);
		return details;
		
	}
	

	@RequestMapping(value="/readAllProject", method = RequestMethod.GET)
	public List<Project> readAllProject() {
		final String uri = "http://localhost:8883/project/getAll";
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")		
		List<Project> list = restTemplate.getForObject(uri, List.class);
		return list;
	}
	
	@RequestMapping(value="/readProject/{productCode}", method = RequestMethod.GET)
	public Project readProject(@PathVariable String id) {
		final String uri = "http://localhost:8883/project/get/{productCode}";
		RestTemplate restTemplate = new RestTemplate();
		Project project = restTemplate.getForObject(uri, Project.class, id);
		return project;
	}
	
	@RequestMapping(value="/updateProject/{productCode}", method = RequestMethod.PUT)
	public Project updateById(@PathVariable String productCode) {
		final String uri = "http://localhost:8883/project/update/{productCode}";
		RestTemplate restTemplate = new RestTemplate();
		Project project = restTemplate.getForObject(uri, Project.class, productCode);
		return project;
	}
	
	@RequestMapping(value="/deleteProject/{productCode}", method = RequestMethod.DELETE)
	public Project deleteById(@PathVariable String productCode) {
		final String uri = "http://localhost:8883/project/delete/{productCode}";
		RestTemplate restTemplate = new RestTemplate();
		Project project = restTemplate.getForObject(uri, Project.class, productCode);
		return project;
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
