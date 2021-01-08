package com.manjuladev.schedulercloud.commons.model.response;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.task.Task;

import java.util.List;

public class ProjectTaskResponse implements Response{
    Project project;
    List<Project> projectList;
    Task task;
    List<Task> taskList;


    public ProjectTaskResponse(Project project, Task task) {
        this.project = project;
        this.task = task;
    }
    public ProjectTaskResponse(Project project, List<Task> taskList) {
        this.project = project;
        this.taskList = taskList;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
