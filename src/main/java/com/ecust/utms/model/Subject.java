package com.ecust.utms.model;

public class Subject {

    private Integer SubjID;//课题ID
    private String Name;//题目
    private String Intro;//简介
    private Integer Status;//状态
    private Integer LimitNum;//限选人数
    private Integer SelectNum;//已选人数
    private String TID;//教师ID
    private String TeaName;//教师名字
    private String StatusName;//状态中文

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName() {
        if(this.Status==0){
            this.StatusName="待审核";
        }
        else{
            this.StatusName="已发布";
        }
    }

    public String getTeaName() {
        return TeaName;
    }

    public void setTeaName(String teaName) {
        TeaName = teaName;
    }

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


    public Subject(Integer subjID, String name, String intro, Integer status, Integer limitNum, Integer selectNum, String TID) {
        SubjID = subjID;
        Name = name;
        Intro = intro;
        Status = status;
        LimitNum = limitNum;
        SelectNum = selectNum;
        this.TID = TID;
    }
}
