package com.ecust.utms.mapper;

import com.ecust.utms.model.SelectSubject;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SelectSubjectMapper {

    @Select("select b.*,c.`Name` StuName\n" +
            "from selectsubject b,student c\n" +
            "where b.SID=c.SID and b.SubjID=#{SubjID}")
    List<SelectSubject> getSelectSubBySubjID(Integer SubjID);


    @Update("update selectsubject\n" +
            "set status = #{Status}\n" +
            "where SID = #{SID}\n" +
            "and SubjID = #{SubjID};")
    Boolean setSelectSubjectStatus(@Param("SubjID") String SubjID, @Param("SID") String SID, @Param("Status") String Status);
}
