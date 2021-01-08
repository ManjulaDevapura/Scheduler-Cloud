package com.manjuladev.schedulercloud.taskservice.repository;

import com.manjuladev.schedulercloud.commons.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByProjectRef(int projectRef);
    List<Task> findAllByUserId(int userId);
}
