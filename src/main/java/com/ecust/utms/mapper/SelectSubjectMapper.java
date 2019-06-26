package com.ecust.utms.mapper;

import com.ecust.utms.model.SelectSubject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SelectSubjectMapper {

    @Select("select b.*,c.`Name` StuName\n" +
            "from selectsubject b,student c\n" +
            "where b.SID=c.SID and b.SubjID=#{SubjID}")
    List<SelectSubject> getSelectSubBySubjID(Integer SubjID);

}
