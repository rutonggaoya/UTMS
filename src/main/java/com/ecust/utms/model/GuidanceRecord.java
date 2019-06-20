package com.ecust.utms.model;

import java.util.Date;

public class GuidanceRecord {

    private Integer GID;//指导记录ID
    private String Content;//内容
    private Date Date;//内容
    private String Place;//地点

    public GuidanceRecord(Integer GID, String content, java.util.Date date, String place) {
        this.GID = GID;
        Content = content;
        Date = date;
        Place = place;
    }

    public Integer getGID() {
        return GID;
    }

    public void setGID(Integer GID) {
        this.GID = GID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    @Override
    public String toString() {
        return "GuidanceRecord{" +
                "GID=" + GID +
                ", Content='" + Content + '\'' +
                ", Date=" + Date +
                ", Place='" + Place + '\'' +
                '}';
    }
}
