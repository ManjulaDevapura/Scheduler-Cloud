package com.manjuladev.schedulercloud.taskservice.controller;

import com.manjuladev.schedulercloud.commons.model.task.Task;
import com.manjuladev.schedulercloud.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @RequestMapping(value = "/by-task-id", method = RequestMethod.GET)
    public ResponseEntity<Task> getByCode(@RequestParam int id) {
        try {
            System.out.println("*************************");
            System.out.println("by-task-id");
            System.out.println(id);
            System.out.println("*************************");
            Task task = taskService.getByCode(id);
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
}
