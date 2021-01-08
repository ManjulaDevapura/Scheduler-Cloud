package com.manjuladev.schedulercloud.schedulerservice.controller;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.response.ProjectTaskDetailResponse;
import com.manjuladev.schedulercloud.commons.model.response.ProjectTaskResponse;
import com.manjuladev.schedulercloud.schedulerservice.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scheduler")
public class ScheduleController {
    @Autowired
    SchedulerService schedulerService;
//
//    @RequestMapping(value = "project", method = RequestMethod.POST)
//    public Project saveProject(@RequestBody Project project) {
//        return schedulerService.saveProject(project);
//    }
//
//    @RequestMapping(value = "projects", method = RequestMethod.GET)
//    public List<Project> getProject() {
//        return schedulerService.getProject();
//    }
//
//    @RequestMapping(value = "project", method = RequestMethod.GET)
//    public Project getProjectByCode(@RequestParam int code) {
//        return schedulerService.getProjectByCode(code);
//    }
//
//    @RequestMapping(value = "project", method = RequestMethod.PATCH)
//    public Project updateProject(@RequestBody Project project) {
//        return schedulerService.updateProject(project);
//    }
//
//    @RequestMapping(value = "project", method = RequestMethod.DELETE)
//    public Project deleteProject(@RequestParam int code) {
//        return schedulerService.deleteProject(code);
//    }


    @RequestMapping(value = "projectDetailed", method = RequestMethod.GET)
    public ProjectTaskDetailResponse getProjectWithTasks(@RequestParam int code) throws Exception {
        return schedulerService.getProjectWithTasks(code);
    }

}
