package com.ecust.utms.model;

public class Subject {

    private Integer SubjID;//课题ID
    private String Name;//题目
    private String Intro;//简介
    private Integer Status;//状态
    private Integer LimitNum;//限选人数
    private Integer SelectNum;//已选人数
    private String TID;//教师ID

    public Integer getSubjID() {
        return SubjID;
    }

    public void setSubjID(Integer subjID) {
        SubjID = subjID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Integer getLimitNum() {
        return LimitNum;
    }

    public void setLimitNum(Integer limitNum) {
        LimitNum = limitNum;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public Integer getSelectNum() {
        return SelectNum;
    }

    public void setSelectNum(Integer selectNum) {
        SelectNum = selectNum;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "SubjID=" + SubjID +
                ", Name='" + Name + '\'' +
                ", Intro='" + Intro + '\'' +
                ", Status=" + Status +
                ", LimitNum=" + LimitNum +
                ", SelectNum=" + SelectNum +
                ", TID='" + TID + '\'' +
                '}';
    }
}
