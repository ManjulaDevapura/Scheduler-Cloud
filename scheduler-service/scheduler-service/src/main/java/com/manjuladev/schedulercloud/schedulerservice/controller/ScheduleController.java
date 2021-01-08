package com.manjuladev.schedulercloud.schedulerservice.controller;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.schedulerservice.service.ProjectSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/scheduler")
public class ScheduleController {
    @Autowired
    ProjectSchedulerService projectSchedulerService;

    @RequestMapping(value = "project", method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project) {
        return projectSchedulerService.saveProject(project);
    }

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    public List<Project> getProject() {
        return projectSchedulerService.getProject();
    }

    @RequestMapping(value = "project", method = RequestMethod.GET)
    public Project getProjectByCode(@RequestParam int code) {
        return projectSchedulerService.getProjectByCode(code);
    }

    @RequestMapping(value = "project", method = RequestMethod.PATCH)
    public Project updateProject(@RequestBody Project project) {
        return projectSchedulerService.updateProject(project);
    }

    @RequestMapping(value = "project", method = RequestMethod.DELETE)
    public Project deleteProject(@RequestParam int code) {
        return projectSchedulerService.deleteProject(code);
    }
}
