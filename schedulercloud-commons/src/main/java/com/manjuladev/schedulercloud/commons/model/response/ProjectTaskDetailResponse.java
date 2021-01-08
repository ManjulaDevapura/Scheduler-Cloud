package com.manjuladev.schedulercloud.commons.model.response;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.task.Task;

import java.util.List;

public class ProjectTaskDetailResponse implements Response {
    Project project;
    List<Task> taskList;

    public ProjectTaskDetailResponse(Project project, List<Task> taskList) {
        this.project = project;
        this.taskList = taskList;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
