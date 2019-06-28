package com.ecust.utms.model;

public class AnswerIntroData {

    private Integer AnswerID;
    private String QueContent;
    private String AnsContent;
    private String DateTime;//回答时间

    public Integer getAnswerID() {
        return AnswerID;
    }

    public void setAnswerID(Integer answerID) {
        AnswerID = answerID;
    }

    public String getQueContent() {
        return QueContent;
    }

    public void setQueContent(String queContent) {
        QueContent = queContent;
    }

    public String getAnsContent() {
        return AnsContent;
    }

    public void setAnsContent(String ansContent) {
        AnsContent = ansContent;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    @Override
    public String toString() {
        return "AnswerIntroData{" +
                "AnswerID=" + AnswerID +
                ", QueContent='" + QueContent + '\'' +
                ", AnsContent='" + AnsContent + '\'' +
                ", DateTime='" + DateTime + '\'' +
                '}';
    }
}
