package com.ecust.utms.model;


public class Administrator {
    private String TID;//管理员ID
    private String Name;//管理员姓名
    private Integer Gender;//管理员性别
    private String Passwd;//管理员密码
    private String Tel;//管理员电话号码
    private String Email;//管理员邮箱
    private Integer DeptID;//管理员学院ID

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
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

//    @Override
//    public String toString() {
//        return "Administrator{" +
//                "TID='" + TID + '\'' +
//                ", Name='" + Name + '\'' +
//                ", Gender=" + Gender +
//                ", Passwd='" + Passwd + '\'' +
//                ", Tel='" + Tel + '\'' +
//                ", Email='" + Email + '\'' +
//                ", DeptID=" + DeptID +
//                '}';
//    }
}
