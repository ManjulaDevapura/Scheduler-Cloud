package com.manjuladev.schedulercloud.taskservice.service;

import com.manjuladev.schedulercloud.commons.model.task.Task;

import java.util.List;

public interface TaskService {
    Task save(Task task);
    List<Task> getAll();
    Task getByCode(int id);
}
