package com.manjuladev.schedulercloud.projectservice.controller;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.request.Filter;
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

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public List<Project> getAll() {
        return projectService.getAll();
    }

    //    public Project getByCode(@RequestBody Project project){
    //    public ResponseEntity<Project> getByCode(@RequestParam int code) {
    //    Project project = projectService.getByCode(project.getCode());
//    public ResponseEntity<Project> getByCode(@PathVariable int code) {

    @RequestMapping(value = "/project/{code}", method = RequestMethod.GET)
    public Project getByCode(@PathVariable int code) {
        Project project = projectService.getByCode(code);
        return project;
//        if (project == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(project);
//        } else {
//            return ResponseEntity.ok().body(project);
//        }
    }


    @RequestMapping(value = "/project", method = RequestMethod.PATCH)
    public Project update(@RequestBody Project project) {
        return projectService.update(project);
    }


    @RequestMapping(value = "/project/{code}", method = RequestMethod.DELETE)
    public Project delete(@PathVariable int code) {
        return projectService.delete(code);
    }


    @RequestMapping(value = "/projectFiltered", method = RequestMethod.POST)
    public List<Project> getAllById(@RequestBody Filter filter) {
        return projectService.filterDivider(filter);
    }
}
