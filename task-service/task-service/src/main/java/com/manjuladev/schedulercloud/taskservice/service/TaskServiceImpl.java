package com.manjuladev.schedulercloud.taskservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.task.Task;
import com.manjuladev.schedulercloud.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            return null;
        }
    }

    @Override
    public Task update(Task task) {
        Optional<Task> updateTask = taskRepository.findById(task.getId());
        if (updateTask.isPresent()) {
            updateTask.get().setName(task.getName() != null ? task.getName() : updateTask.get().getName());
            updateTask.get().setDescription(task.getDescription() != null ? task.getDescription() : updateTask.get().getDescription());
            updateTask.get().setNoHrs(task.getNoHrs() != 0 ? task.getNoHrs() : updateTask.get().getNoHrs());
            updateTask.get().setUserId(task.getUserId() != 0 ? task.getUserId() : updateTask.get().getUserId());
            updateTask.get().setDueDate(task.getDueDate() != null ? task.getDueDate() : updateTask.get().getDueDate());
            return taskRepository.save(updateTask.get());
        } else {
            return null;
        }
    }

    @Override
    public Task delete(int id) {
        Optional<Task> deletedTask = taskRepository.findById(id);
        if (deletedTask.isPresent()) {
            taskRepository.deleteById(id);
            return deletedTask.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Task> getAllByProjectRef(int projectRef) {
        return taskRepository.findAllByProjectRef(projectRef);
    }

    @Override
    public List<Task> getAllByUserId(int userId) {
        return taskRepository.findAllByUserId(userId);
    }
}
