package com.manjuladev.schedulercloud.taskservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.task.Task;

import java.util.List;

public interface TaskService {
    Task save(Task task);

    List<Task> getAll();

    Task getById(int id);

    Task update(Task task);

    Task delete(int id);
    
    List<Task> getAllByProjectRef(int projectRef);

    List<Task> getAllByUserId(int userId);
}
