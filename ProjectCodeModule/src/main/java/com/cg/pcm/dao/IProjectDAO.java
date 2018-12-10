package com.cg.pcm.dao;

import java.util.List;

import javax.validation.Valid;

import com.cg.pcm.entity.Project;

public interface IProjectDAO {

	Project insertData(@Valid Project project);

	List<Project> getAllDetails();

	Project getDetailsById(String id);

	Project updateDetailsById(String id, Project project);

	Project deleteDetailsById(String id);

}
