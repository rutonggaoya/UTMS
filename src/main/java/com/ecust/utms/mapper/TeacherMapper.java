package com.ecust.utms.mapper;

import com.ecust.utms.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where TID=#{TID}")
    Teacher getTea(String TID);
}
