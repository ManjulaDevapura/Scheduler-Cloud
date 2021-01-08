package com.manjuladev.schedulercloud.projectservice.repository;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findAllByStatus(boolean status);
    List<Project> findAllByEndDate(Date endDate);
}
