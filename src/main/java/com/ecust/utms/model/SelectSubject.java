package com.ecust.utms.model;

public class SelectSubject {

    private Integer SSID;//选课题ID
    private Integer VOrder;//志愿顺序
    private Integer Status;//状态
    private String StatusName;
    private Integer SubjID;//课题ID
    private String SID;//学生ID
    private String StuName;

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName() {
        if(this.Status==0){
            this.StatusName="待审核";
        }
        else if(this.Status==1){
            this.StatusName="已通过";
        }else{
            this.StatusName="已拒绝";
        }
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

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

    @Override
    public String toString() {
        return "SelectSubject{" +
                "SSID=" + SSID +
                ", VOrder=" + VOrder +
                ", Status=" + Status +
                ", StatusName='" + StatusName + '\'' +
                ", SubjID=" + SubjID +
                ", SID='" + SID + '\'' +
                ", StuName='" + StuName + '\'' +
                '}';
    }
}
