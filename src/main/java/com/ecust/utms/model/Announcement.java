package com.ecust.utms.model;

import java.util.Date;

public class Announcement {

    private Integer AID;//公告ID
    private String Content;//公告内容
    private String Title;//公告标题
    private Date DateTime;//公告时间
    private String PubID;//管理员ID
    private Integer ReadNum;//阅读数

    public Integer getAID() {
        return AID;
    }

    public void setAID(Integer AID) {
        this.AID = AID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public String getPubID() {
        return PubID;
    }

    public void setPubID(String pubID) {
        PubID = pubID;
    }

    public Integer getReadNum() {
        return ReadNum;
    }

    public void setReadNum(Integer readNum) {
        ReadNum = readNum;
    }

}
