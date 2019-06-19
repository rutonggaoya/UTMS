package com.ecust.utms.model;

import java.util.Date;

public class Message {

    private Integer MID;//私信ID
    private String Content;//内容
    private Date DateTime;//发送时间
    private Integer SendID;//发送者ID
    private Integer RecipID;//接收者ID

    public Integer getMID() {
        return MID;
    }

    public void setMID(Integer MID) {
        this.MID = MID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public Integer getSendID() {
        return SendID;
    }

    public void setSendID(Integer sendID) {
        SendID = sendID;
    }

    public Integer getRecipID() {
        return RecipID;
    }

    public void setRecipID(Integer recipID) {
        RecipID = recipID;
    }
}
