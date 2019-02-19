package com.sunland.pojo;

import java.io.Serializable;

public class SysParameters implements Serializable {
    private String paraname;

    private String paravalue;

    private String description;

    private String sortby;

    private String status;

    private static final long serialVersionUID = 1L;

    public String getParaname() {
        return paraname;
    }

    public void setParaname(String paraname) {
        this.paraname = paraname == null ? null : paraname.trim();
    }

    public String getParavalue() {
        return paravalue;
    }

    public void setParavalue(String paravalue) {
        this.paravalue = paravalue == null ? null : paravalue.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSortby() {
        return sortby;
    }

    public void setSortby(String sortby) {
        this.sortby = sortby == null ? null : sortby.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}