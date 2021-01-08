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

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public List<Project> getAll() {
        return projectService.getAll();
    }

    //    public Project getByCode(@RequestBody Project project){
    //    public ResponseEntity<Project> getByCode(@RequestParam int code) {
    @RequestMapping(value = "/project/{code}", method = RequestMethod.GET)
    public ResponseEntity<Project> getByCode(@PathVariable int code) {
        try {
            //    Project project = projectService.getByCode(project.getCode());
            Project project = projectService.getByCode(code);
            if (project == null) {
                //    return ResponseEntity.notFound().build();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(project);
            } else {
                return ResponseEntity.ok().body(project);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }



    @RequestMapping(value = "/project", method = RequestMethod.PATCH)
    public Project update(@RequestBody Project project) {
        return projectService.update(project);
    }


    @RequestMapping(value = "/project/{code}", method = RequestMethod.DELETE)
    public Project delete(@PathVariable int code) {
        return projectService.delete(code);
    }
}
