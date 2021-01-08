package com.manjuladev.schedulercloud.projectservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.request.Filter;
import com.manjuladev.schedulercloud.commons.model.task.Task;
import com.manjuladev.schedulercloud.projectservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
//            updateProj.get().setNoOfUsers(project.getNoOfUsers()!=0?project.getNoOfUsers():updateProj.get().getNoOfUsers());
//            updateProj.get().setTotalHrs(project.getTotalHrs()!=0?project.getTotalHrs():updateProj.get().getTotalHrs());
            updateProj.get().setName(project.getName() != null ? project.getName() : updateProj.get().getName());
            updateProj.get().setStatus(project.getStatus() != null ? project.getStatus() : updateProj.get().getStatus());
            updateProj.get().setEndDate(project.getEndDate() != null ? project.getEndDate() : updateProj.get().getEndDate());
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

    @Override
    public List<Project> filterDivider(Filter filter) {
        if (filter.getFilterType().contains("status")) {
            return getAllByStatus(filter.getFilterBool());
        } else if (filter.getFilterType().contains("endDate")) {
            return getAllByEndDate(filter.getFilterDate());
        } else {
            return null;
        }
    }


    public List<Project> getAllByStatus(boolean status) {
        return projectRepository.findAllByStatus(status);
    }


    public List<Project> getAllByEndDate(Date endDate) {
        return projectRepository.findAllByEndDate(endDate);
    }


}
