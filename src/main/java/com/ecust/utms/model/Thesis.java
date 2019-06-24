package com.ecust.utms.model;

import java.util.Date;

public class Thesis {

    private Integer ThesisID;//论文ID
    private String Name;//论文题目
    private String TPath;//论文路径
    private Date DateTime;//上传时间
    private String SID;//学生ID;

    public Integer getThesisID() {
        return ThesisID;
    }

    public void setThesisID(Integer thesisID) {
        ThesisID = thesisID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTPath() {
        return TPath;
    }

    public void setTPath(String TPath) {
        this.TPath = TPath;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    @Override
    public String toString() {
        return "Thesis{" +
                "ThesisID=" + ThesisID +
                ", Name='" + Name + '\'' +
                ", TPath='" + TPath + '\'' +
                ", DateTime=" + DateTime +
                ", SID='" + SID + '\'' +
                '}';
    }
}
