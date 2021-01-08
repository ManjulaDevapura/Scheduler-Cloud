package com.manjuladev.schedulercloud.taskservice.controller;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.request.Filter;
import com.manjuladev.schedulercloud.commons.model.task.Task;
import com.manjuladev.schedulercloud.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getById(@PathVariable int id) {
        try {
            Task task = taskService.getById(id);
            if (task == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(task);
            } else {
                return ResponseEntity.ok().body(task);
            }
        } catch (Exception e) {
            System.out.println("HttpStatus.EXPECTATION_FAILED   %%%%%%%%%%%%%%");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }


    @RequestMapping(value = "/task", method = RequestMethod.PATCH)
    public Task update(@RequestBody Task task) {
        return taskService.update(task);
    }


    @RequestMapping(value = "/task/{code}", method = RequestMethod.DELETE)
    public Task delete(@PathVariable int id) {
        return taskService.delete(id);
    }


    @RequestMapping(value = "/taskFiltered", method = RequestMethod.GET)
    public List<Task> getAllById(@RequestBody Filter filter) {
        if (filter.getFilterType().contains("project")) {
            return taskService.getAllByProjectRef(filter.getFilterId());
        } else if (filter.getFilterType().contains("user")) {
            return taskService.getAllByUserId(filter.getFilterId());
        } else {
            return null;
        }
    }


}
