package com.manjuladev.schedulercloud.projectservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.projectservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getByCode(int code) {
        Optional<Project> project = projectRepository.findById(code);
        if (project.isPresent()) {
            return project.get();
        } else {
            return null;
        }
    }

    @Override
    public Project update(Project project) {
        Optional<Project> updateProj = projectRepository.findById(project.getCode());
        if (updateProj.isPresent()) {
            updateProj.get().setName(project.getName());
            updateProj.get().setStatus(project.getStatus());
            updateProj.get().setTotalHrs(project.getTotalHrs());
            return projectRepository.save(updateProj.get());
        } else {
            return null;
        }
    }

    @Override
    public Project delete(int code) {
        Optional<Project> deletedProj = projectRepository.findById(code);
        if (deletedProj.isPresent()) {
            projectRepository.deleteById(code);
            return deletedProj.get();
        } else {
            return null;
        }
    }
}
