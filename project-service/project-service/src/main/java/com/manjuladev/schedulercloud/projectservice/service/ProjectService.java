package com.manjuladev.schedulercloud.projectservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;

import java.util.Date;
import java.util.List;

public interface ProjectService {
    Project save(Project project);

    List<Project> getAll();

    Project getByCode(int code);

    Project update(Project project);

    Project delete(int code);

    List<Project> getAllByStatus(boolean status);
    List<Project> getAllByEndDate(Date endDate);
}
