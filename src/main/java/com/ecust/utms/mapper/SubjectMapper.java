package com.ecust.utms.mapper;

import com.ecust.utms.model.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface SubjectMapper {

    @Select("select * from subject")
    List<Subject> getAllSub();

    @Select("select * from subject where TID=#{TID}")
    List<Subject> getTeaSub(String TID);

    @Select("select * from subject where SubjID=#{SubjID}")
    Subject getSub(Integer SubjID);

    @Options(useGeneratedKeys = true,keyProperty = "SubjID")
    @Insert("insert into subject (Name,Intro,LimitNum,SelectNum,TID,Status) values(#{Name},#{Intro},#{LimitNum},#{SelectNum},#{TID},#{Status})")
    int insertSub(Subject subject);


    @Delete("delete from subject where SubjID=#{SubjID}")
    int deleteSub(Integer SubjID);

//    @Update("update administrator set Name=#{Name},Gender=#{Gender},Passwd=#{Passwd},Tel=#{Tel},Email=#{Email},DeptID=#{DeptID} where TID={#TID}")
//    int updateAd(Administrator administrator);

    @Select("select * from subject as s, teacher as t where s.TID = t.TID and t.DeptID=#{DeptID}")
    List<Subject> getSubListByDept(String DeptID);

    @Select("select s.SubjID, s.Name, s.Intro, s.LimitNum, s.SelectNum, s.Status, s.TID from subject as s, selectsubject as ss " +
            "where ss.SID=#{SID} and ss.SubjID = s.SubjID")
    Subject getStuSub(String SID);
}
