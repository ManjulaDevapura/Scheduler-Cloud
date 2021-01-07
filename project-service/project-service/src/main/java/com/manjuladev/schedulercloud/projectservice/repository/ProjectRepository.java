package com.manjuladev.schedulercloud.projectservice.repository;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
