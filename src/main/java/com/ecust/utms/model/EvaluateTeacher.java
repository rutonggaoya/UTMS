package com.ecust.utms.model;

public class EvaluateTeacher {

    private Integer ETID;//表ID
    private Integer EGrade;//评价分数
    private String EContent;//评价内容
    private String SID;//学生ID

    public Integer getETID() {
        return ETID;
    }

    public void setETID(Integer ETID) {
        this.ETID = ETID;
    }

    public Integer getEGrade() {
        return EGrade;
    }

    public void setEGrade(Integer EGrade) {
        this.EGrade = EGrade;
    }

    public String getEContent() {
        return EContent;
    }

    public void setEContent(String EContent) {
        this.EContent = EContent;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }
}
