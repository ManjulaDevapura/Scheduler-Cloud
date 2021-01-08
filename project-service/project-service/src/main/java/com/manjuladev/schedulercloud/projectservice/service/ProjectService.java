package com.manjuladev.schedulercloud.projectservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.request.Filter;
import com.manjuladev.schedulercloud.commons.model.task.Task;

import java.util.Date;
import java.util.List;

public interface ProjectService {
    Project save(Project project);

    List<Project> getAll();

    Project getByCode(int code);

    Project update(Project project);

    Project delete(int code);

    List<Project> filterDivider(Filter filter);
//    List<Project> getAllByStatus(boolean status);
//    List<Project> getAllByEndDate(Date endDate);
}
