package com.ecust.utms.model;

import java.util.Date;

public class Answer {

    private Integer AnswerID;//回答表自增ID
    private Date DateTime;//回答时间
    private String Content;//回答内容
    private Integer QID;//问题ID
    private String RespondentID;//回答人ID


    public Integer getAnswerID() {
        return AnswerID;
    }

    public void setAnswerID(Integer answerID) {
        AnswerID = answerID;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Integer getQID() {
        return QID;
    }

    public void setQID(Integer QID) {
        this.QID = QID;
    }

    public String getRespondentID() {
        return RespondentID;
    }

    public void setRespondentID(String respondentID) {
        RespondentID = respondentID;
    }
}
