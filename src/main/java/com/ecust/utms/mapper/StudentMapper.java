package com.ecust.utms.mapper;

import com.ecust.utms.model.Student;
import com.ecust.utms.model.StudentPersonalPageData;
import com.ecust.utms.model.StudentSubject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.ResultSet;
import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student where SID=#{SID}")
    Student getStu(String SID);

    @Select("select a.`Name` as `Name`, a.SID as `SID`, a.Gender as `Gender`, a.Tel as `Tel`, a.Major as `Major`, a.`Email` as `Email`, a.Passwd as `Passwd`, d.`Name` as `DeptName`, s.`Name` as `SubjName`,\n" +
            "t.`Name` as `Instructor`, h.`Name` as ThesisName, e.EGrade as `EGrade`, t2.`Name` as `Grader`\n" +
            "from`student` as a, \n" +
            "`subject` as s,\n" +
            "`selectsubject` as b,\n" +
            "`department` as d,\n" +
            "`teacher` as t,\n" +
            "`thesis` as h,\n" +
            "`evaluatethesis` as e,\n" +
            "`teacher` as t2\n" +
            "where a.SID = b.SID\n" +
            "and a.DeptID = d.DeptID\n" +
            "and s.SubjID = b.SubjID\n" +
            "and s.TID = t.TID\n" +
            "and h.SID = b.SID\n" +
            "and h.ThesisID = e.ThesisID\n" +
            "and t2.TID = e.TID\n" +
            "and b.Status = 1\n" +
            "and b.SID = #{SID};")
    StudentPersonalPageData getStudentPersonalPageData(String SID);

    @Select("select * from student order by SID desc")
    List<Student> getAllStudent();
}
