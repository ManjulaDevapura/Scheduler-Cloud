package com.manjuladev.schedulercloud.schedulerservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.task.Task;
import com.manjuladev.schedulercloud.commons.model.response.ProjectTaskResponse;

import java.util.List;

public interface ProjectSchedulerService {

    Project saveProject(Project project);

    List<Project> getProject();

    Project getProjectByCode(int code);

    Project updateProject(Project project);

    Project deleteProject(int code);
}
