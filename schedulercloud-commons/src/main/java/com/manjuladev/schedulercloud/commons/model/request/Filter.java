package com.manjuladev.schedulercloud.commons.model.request;

import java.util.Date;

public class Filter {
    String filterType;
    int filterId;

    int filterInt;
    String filterString;
    boolean filterBool;
    Date filterDate;

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

    public int getFilterInt() {
        return filterInt;
    }

    public void setFilterInt(int filterInt) {
        this.filterInt = filterInt;
    }

    public String getFilterString() {
        return filterString;
    }

    public void setFilterString(String filterString) {
        this.filterString = filterString;
    }

    public boolean getFilterBool() {
        return filterBool;
    }

    public void setFilterBool(boolean filterBool) {
        this.filterBool = filterBool;
    }

    public Date getFilterDate() {
        return filterDate;
    }

    public void setFilterDate(Date filterDate) {
        this.filterDate = filterDate;
    }
}
