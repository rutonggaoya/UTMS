package com.ecust.utms.model;

import javax.validation.constraints.Email;

public class Teacher {

    private String TID;//教职工ID
    private String Title;//职称
    private String Name;//姓名
    private Integer Gender;//性别
    private String Passwd;//密码
    private String Tel;//手机号码
    private String Email;//邮箱
    private Integer DeptID;//院系ID

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getGender() {
        return Gender;
    }

    public void setGender(Integer gender) {
        Gender = gender;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String passwd) {
        Passwd = passwd;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getDeptID() {
        return DeptID;
    }

    public void setDeptID(Integer deptID) {
        DeptID = deptID;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "TID='" + TID + '\'' +
                ", Title='" + Title + '\'' +
                ", Name='" + Name + '\'' +
                ", Gender=" + Gender +
                ", Passwd='" + Passwd + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Email='" + Email + '\'' +
                ", DeptID=" + DeptID +
                '}';
    }
}
