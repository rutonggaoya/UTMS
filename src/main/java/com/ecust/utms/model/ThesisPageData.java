package com.ecust.utms.model;

import java.util.Date;

public class ThesisPageData {

    private Integer ThesisID;
    private String SubName;
    private String ThesisName;
    private String StuName;
    private Date DateTime;
    private String TPath;

    public Integer getThesisID() {
        return ThesisID;
    }

    public void setThesisID(Integer thesisID) {
        ThesisID = thesisID;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }

    public String getThesisName() {
        return ThesisName;
    }

    public void setThesisName(String thesisName) {
        ThesisName = thesisName;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public String getTPath() {
        return TPath;
    }

    public void setTPath(String TPath) {
        this.TPath = TPath;
    }

    @Override
    public String toString() {
        return "ThesisPageData{" +
                "ThesisID=" + ThesisID +
                ", SubName='" + SubName + '\'' +
                ", ThesisName='" + ThesisName + '\'' +
                ", StuName='" + StuName + '\'' +
                ", DateTime=" + DateTime +
                ", TPath='" + TPath + '\'' +
                '}';
    }
}
