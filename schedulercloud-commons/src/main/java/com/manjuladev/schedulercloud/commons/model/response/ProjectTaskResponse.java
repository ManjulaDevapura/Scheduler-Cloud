package com.manjuladev.schedulercloud.commons.model.response;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.task.Task;

public class ProjectTaskResponse implements Response{
    Project project;
    Task task;

    public ProjectTaskResponse(Project project, Task task) {
        this.project = project;
        this.task = task;
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
}
