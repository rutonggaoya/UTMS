package com.ecust.utms.model;

public class EvaluateThesis {

    private Integer EThesisID;//表ID
    private Integer EGrade;//评价论文分数
    private String EContent;//评价内容
    private Integer ThesisID;//论文ID
    private String TID;//教师ID

    public Integer getEThesisID() {
        return EThesisID;
    }

    public void setEThesisID(Integer EThesisID) {
        this.EThesisID = EThesisID;
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

    public Integer getThesisID() {
        return ThesisID;
    }

    public void setThesisID(Integer thesisID) {
        ThesisID = thesisID;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }
}
