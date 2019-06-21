package com.ecust.utms.mapper;

import com.ecust.utms.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {

    @Select("select * from student where SID=#{SID}")
    Student getStu(String SID);
}
