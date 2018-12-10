package com.cg.pcm.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pcm.entity.Project;
import com.cg.pcm.exception.UserNotFoundException;
import com.cg.pcm.repository.ProjectRepository;

@Repository
public class ProjectDAOImpl implements IProjectDAO {
	
	@Autowired
	private ProjectRepository repository;
	
	@Override
	public Project insertData(@Valid Project project) {
		long startDateSecs=project.getStartDate().getTime();
		long endDateSecs=project.getEndDate().getTime();
		long diff=startDateSecs-endDateSecs;
		if(diff>=0){
			throw new UserNotFoundException("End date should be greater than start date");
		}
		repository.save(project);
		return project;
	}

	@Override
	public List<Project> getAllDetails() {
		return repository.findAll();
	}

	@Override
	public Project getDetailsById(String id) {
		Project project=repository.findOne(id);
		if(project==null){
			throw new UserNotFoundException("No such id present : "+id);
		}
		return project;
	}


	@Override
	public Project updateDetailsById(String id, Project project) {
		repository.save(project);
		return project;
	}

	@Override
	public Project deleteDetailsById(String id) {
		Project project = repository.findOne(id);
		repository.delete(id);
		return project;
	}

}
