package com.manjuladev.schedulercloud.taskservice.repository;

public class Filter {
    public String filterType;
    public int filterId;

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public int getFilterId() {
        return filterId;
    }

    public void setFilterId(int filterId) {
        this.filterId = filterId;
    }
}
