package com.ecust.utms.model;

public class DefenserResult {

    private Integer RID;//答辩成绩ID
    private Integer Grade;//答辩分数
    private String TID;//登记者ID
    private String SID;//学生ID

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public Integer getRID() {
        return RID;
    }

    public void setRID(Integer RID) {
        this.RID = RID;
    }

    public Integer getGrade() {
        return Grade;
    }

    public void setGrade(Integer grade) {
        Grade = grade;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }
}
