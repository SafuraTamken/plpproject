package com.cg.pcm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pcm.entity.Project;
import com.cg.pcm.service.IProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	IProjectService service;

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Project create(@Valid @RequestBody Project project) {
		return service.insertData(project);
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Project> getAll() {
		return service.getAllDetails();
	}
	
	@RequestMapping(value="/get/{productCode}",method=RequestMethod.GET)
	public Project getById(@PathVariable String productCode) {
		return service.getDetailsById(productCode);
	}
	@RequestMapping(value="/update/{productCode}",method=RequestMethod.PUT)
	public Project updateById(@PathVariable String productCode,@RequestBody Project project) {
		return service.updateDetailsById(productCode,project);
	}
	@RequestMapping(value="/delete/{productCode}",method=RequestMethod.DELETE)
	public Project deleteById(@PathVariable String productCode) {
		return service.deleteDetailsById(productCode);
	}
}
