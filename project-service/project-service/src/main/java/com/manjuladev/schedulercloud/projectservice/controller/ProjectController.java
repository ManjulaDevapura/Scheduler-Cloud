package com.manjuladev.schedulercloud.projectservice.controller;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @RequestMapping(value = "/by-project-code", method = RequestMethod.GET)
//    public Project getByCode(@RequestBody Project project){
    public ResponseEntity<Project> getByCode(@RequestParam int code) {
        try {
            System.out.println("*************************");
            System.out.println("by-project-code");
            System.out.println(code);
//        System.out.println(project);
//        System.out.println(project.getCode());
            System.out.println("*************************");
//        Project project = projectService.getByCode(project.getCode());
            Project project = projectService.getByCode(code);
            if (project == null) {
//                return ResponseEntity.notFound().build();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(project);
            } else {
                return ResponseEntity.ok().body(project);
            }
        } catch (Exception e) {
            System.out.println("HttpStatus.EXPECTATION_FAILED   %%%%%%%%%%%%%%");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}
