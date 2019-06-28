package com.ecust.utms.mapper;

import com.ecust.utms.model.EvaluateThesis;
import com.ecust.utms.model.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where TID=#{TID}")
    Teacher getTea(String TID);

    @Update("update teacher set Title=#{Title},Name=#{Name},Gender=#{Gender},Passwd=#{Passwd},Tel=#{Tel},Email=#{Email},DeptID=#{DeptID} where TID=#{TID}")
    int updateTea(Teacher teacher);

    @Insert("insert into evaluatethesis (TID,ThesisID,EContent,EGrade) values (#{TID},#{ThesisID},#{EContent},#{EGrade})")
    int evaluateThesis(EvaluateThesis evaluateThesis);

}
