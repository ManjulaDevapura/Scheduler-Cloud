package com.manjuladev.schedulercloud.commons.model.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    int id;
    int projectRef;
    String name;
    int noHrs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectRef() {
        return projectRef;
    }

    public void setProjectRef(int projectRef) {
        this.projectRef = projectRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoHrs() {
        return noHrs;
    }

    public void setNoHrs(int noHrs) {
        this.noHrs = noHrs;
    }
}
