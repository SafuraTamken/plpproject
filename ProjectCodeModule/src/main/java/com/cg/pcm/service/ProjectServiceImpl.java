package com.cg.pcm.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pcm.dao.IProjectDAO;
import com.cg.pcm.entity.Project;

@Service
@Transactional
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	IProjectDAO dao;

	@Override
	public Project insertData(@Valid Project project) {
		return dao.insertData(project);
	}

	@Override
	public List<Project> getAllDetails() {
		return dao.getAllDetails();
	}

	@Override
	public Project getDetailsById(String id) {
		return dao.getDetailsById(id);
	}

	@Override
	public Project updateDetailsById(String id, Project project) {
		return dao.updateDetailsById(id, project);
	}

	@Override
	public Project deleteDetailsById(String id) {
		return dao.deleteDetailsById(id);
	}

}
