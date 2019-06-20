package com.ecust.utms.model;

import java.util.Date;

public class Question {

    private Integer QID;//问题ID
    private String Content;//内容
    private String Desc;//具体描述
    private Date DateTime;//提问时间
    private String SID;//学生ID

    public Integer getQID() {
        return QID;
    }

    public void setQID(Integer QID) {
        this.QID = QID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
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
}
