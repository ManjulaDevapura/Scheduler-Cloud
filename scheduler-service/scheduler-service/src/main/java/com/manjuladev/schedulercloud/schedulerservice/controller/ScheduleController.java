package com.manjuladev.schedulercloud.schedulerservice.controller;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.schedulerservice.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/scheduler")
public class ScheduleController {
    @Autowired
    SchedulerService schedulerService;

    @RequestMapping(value = "project", method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project) {
        System.out.println("Hi ****************************************************");
        System.out.println("Hi ****************************************************");
        System.out.println("Hi ****************************************************");
        System.out.println(project);
        System.out.println(project.getName());
        System.out.println(project.getTotalHrs());
        return schedulerService.saveProject(project);
    }

//    List<Project> getProject();
//    Project getProjectByCode();
//    Project updateProject(Project project);
//    Project deleteProject(int code);

}
