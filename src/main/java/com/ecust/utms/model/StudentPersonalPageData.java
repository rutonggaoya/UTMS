package com.ecust.utms.model;

public class StudentPersonalPageData {

    // 个人基本信息
    private String SID;
    private String Name;
    private Integer Gender;
    private String Major;
    private Integer DeptID;
    private String Passwd;
    private String Tel;
    private String Email;

    // 参与课题信息
    private String SubjName;    // 课题名称
    private String Instructor;  // 指导老师
    private String ThesisName;  // 论文题目
    private String EGrade;      // 论文成绩
//    private String Grade;      // 评价老师


    // Getter & Setter

    public String getThesisName() {
        return ThesisName;
    }

    public void setThesisName(String thesisName) {
        ThesisName = thesisName;
    }

    public Integer getDeptID() {
        return DeptID;
    }

    public void setDeptID(Integer deptID) {
        DeptID = deptID;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
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

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
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

    public String getSubjName() {
        return SubjName;
    }

    public void setSubjName(String subjName) {
        SubjName = subjName;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String instructor) {
        Instructor = instructor;
    }

    public String getEGrade() {
        return EGrade;
    }

    public void setEGrade(String EGrade) {
        this.EGrade = EGrade;
    }

//    public String getGrader() {
//        return Grader;
//    }
//
//    public void setGrader(String grader) { Grader = grader; }

    @Override
    public String toString() {
        return "StudentPersonalPageData{" +
                "SID='" + SID + '\'' +
                ", Name='" + Name + '\'' +
                ", Gender=" + Gender +
                ", Major='" + Major + '\'' +
                ", DeptID=" + DeptID +
                ", Passwd='" + Passwd + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Email='" + Email + '\'' +
                ", SubjName='" + SubjName + '\'' +
                ", Instructor='" + Instructor + '\'' +
                ", ThesisName='" + ThesisName + '\'' +
                ", EGrade='" + EGrade + '\'' +
                '}';
    }

    public StudentPersonalPageData(String SID, String name, Integer gender, String major, Integer deptID, String passwd, String tel, String email, String subjName, String instructor, String thesisName, String EGrade) {
        this.SID = SID;
        Name = name;
        Gender = gender;
        Major = major;
        DeptID = deptID;
        Passwd = passwd;
        Tel = tel;
        Email = email;
        SubjName = subjName;
        Instructor = instructor;
        ThesisName = thesisName;
        this.EGrade = EGrade;
//        Grader = grader;
    }

    public StudentPersonalPageData() {
    }
}
