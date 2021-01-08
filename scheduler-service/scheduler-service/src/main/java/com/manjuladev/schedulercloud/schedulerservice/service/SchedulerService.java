package com.manjuladev.schedulercloud.schedulerservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.response.ProjectTaskDetailResponse;
import com.manjuladev.schedulercloud.commons.model.task.Task;
import com.manjuladev.schedulercloud.commons.model.response.ProjectTaskResponse;
import com.manjuladev.schedulercloud.commons.model.response.ProjectTaskResponse;

import java.util.List;

public interface SchedulerService {

    ProjectTaskDetailResponse getProjectWithTasks(int code) throws Exception;


//    Project saveProject(Project project);
//
//    List<Project> getProject();
//
//
//    Project updateProject(Project project);
//
//    Project deleteProject(int code);

}
