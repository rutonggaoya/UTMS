package com.ecust.utms.model;

public class Attachment {

    private Integer ATID;//附件ID
    private String ATPath;//附件路径
    private Integer AID;//公告ID
    private String ATName; //附件名称

    public String getATPath() {
        return ATPath;
    }

    public void setATPath(String ATPath) {
        this.ATPath = ATPath;
    }

    public Integer getAID() {
        return AID;
    }

    public void setAID(Integer AID) {
        this.AID = AID;
    }

    public Integer getATID() {
        return ATID;
    }

    public void setATID(Integer ATID) {
        this.ATID = ATID;
    }

    public String getATName() {
        return ATName;
    }

    public void setATName(String ATName) {
        this.ATName = ATName;
    }
}
