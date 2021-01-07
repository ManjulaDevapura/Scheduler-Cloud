package com.manjuladev.schedulercloud.taskservice.repository;

import com.manjuladev.schedulercloud.commons.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
