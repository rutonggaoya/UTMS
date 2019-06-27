package com.ecust.utms.model;

import java.util.Date;

public class StudentSubject {
    private String SID;             //学生ID
    private String Name;            // 学生姓名
    private String SubjName;        //课题名称
    private String SimilarityRate;  //查重率
    private String Grade = "暂未答辩";   //答辩分数

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSubjName() {
        return SubjName;
    }

    public void setSubjName(String subjName) {
        SubjName = subjName;
    }

    public String getSimilarityRate() {
        return SimilarityRate;
    }

    public void setSimilarityRate(String similarityRate) {
        SimilarityRate = similarityRate;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }


}
