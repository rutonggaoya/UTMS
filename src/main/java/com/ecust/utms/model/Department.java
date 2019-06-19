package com.ecust.utms.model;

public class Department {

    private Integer DeptID;//院系ID
    private String Name;//院系名称

    public Integer getDeptID() {
        return DeptID;
    }

    public void setDeptID(Integer deptID) {
        DeptID = deptID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
