package com.ecust.utms.model;

public class SelectSubject {

    private Integer SSID;//选课题ID
    private Integer VOrder;//志愿顺序
    private Integer Status;//状态
    private Integer SubjID;//课题ID
    private String SID;//学生ID

    public Integer getSSID() {
        return SSID;
    }

    public void setSSID(Integer SSID) {
        this.SSID = SSID;
    }

    public Integer getVOrder() {
        return VOrder;
    }

    public void setVOrder(Integer VOrder) {
        this.VOrder = VOrder;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Integer getSubjID() {
        return SubjID;
    }

    public void setSubjID(Integer subjID) {
        SubjID = subjID;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }
}
