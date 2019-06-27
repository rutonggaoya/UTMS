package com.ecust.utms.mapper;

import com.ecust.utms.model.EvaluateTeacher;
import com.ecust.utms.model.Student;
import com.ecust.utms.model.StudentPersonalPageData;
import com.ecust.utms.model.StudentSubject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.ResultSet;
import java.util.List;

@Mapper
public interface StudentMapper {



    @Select("select * from student where SID=#{SID}")
    Student getStu(String SID);

    @Select("select a.`Name` as `Name`, a.SID as `SID`, a.Gender as `Gender`, a.Tel as `Tel`, a.Major as `Major`,a.`Email` as `Email`, a.Passwd as `Passwd`, d.`DeptID` as `DeptID`, s.`Name` as `SubjName`,\n" +
            "            t.`Name` as `Instructor`, h.`Name` as ThesisName, r.Grade as `EGrade`\n" +
            "            from `student` as a,\n" +
            "            `subject` as s,\n" +
            "            `selectsubject` as b,\n" +
            "            `department` as d,\n" +
            "            `teacher` as t,\n" +
            "            `thesis` as h,\n" +
            "            `similarityratecheck` as e,\n" +
            "            `defenseresult` as r\n" +
            "            where a.SID = b.SID\n" +
            "            and a.DeptID = d.DeptID\n" +
            "            and s.SubjID = b.SubjID\n" +
            "            and s.TID = t.TID\n" +
            "            and h.SID = b.SID\n" +
            "            and h.ThesisID = e.ThesisID\n" +
            "            and r.SID=a.SID\n" +
            "            and b.Status = 1\n" +
            "            and b.SID = #{SID}")
    StudentPersonalPageData getStudentPersonalPageData(String SID);

    @Select("select * from student order by SID desc")
    List<Student> getAllStudent();

    @Select("SELECT\n" +
            "\ta.`Name` AS `Name`,\n" +
            "\ta.SID AS `SID`,\n" +
            "\ta.Gender AS `Gender`,\n" +
            "\ta.Tel AS `Tel`,\n" +
            "\ta.Major AS `Major`,\n" +
            "\ta.`Email` AS `Email`,\n" +
            "\ta.Passwd AS `Passwd`,\n" +
            "\td.`DeptID` AS `DeptID`,\n" +
            "\ts.`Name` AS `SubjName`,\n" +
            "\tt.`Name` AS `Instructor`,\n" +
            "\th.`Name` AS ThesisName,\n" +
            "\tr.Grade AS `EGrade`\n" +
            "FROM\n" +
            "\t`student` AS a,\n" +
            "\t`subject` AS s,\n" +
            "\t`selectsubject` AS b,\n" +
            "\t`department` AS d,\n" +
            "\t`teacher` AS t,\n" +
            "\t`thesis` AS h,\n" +
            "\t`similarityratecheck` AS e,\n" +
            "\t`defenseresult` AS r\n" +
            "WHERE\n" +
            "\ta.SID = b.SID\n" +
            "AND a.DeptID = d.DeptID\n" +
            "AND s.SubjID = b.SubjID\n" +
            "AND s.TID = t.TID\n" +
            "AND h.SID = b.SID\n" +
            "AND h.ThesisID = e.ThesisID\n" +
            "AND r.SID = a.SID\n" +
            "AND b.`STATUS` = 1\n" +
            "AND a.SID = #{SID}")
    StudentPersonalPageData getSPPD(String SID);

    @Select("select * from evaluateteacher where SID=#{SID}")
    EvaluateTeacher getETbySID(String SID);

    @Insert("insert into evaluateteacher(SID,EGrade,EContent) values(#{SID},#{EGrade},#{EContent})")
    int insertETBbySID(EvaluateTeacher et);
}
