package com.ecust.utms.mapper;

import com.ecust.utms.model.Thesis;
import com.ecust.utms.model.ThesisPageData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ThesisMapper {

    @Select("select d.* from teacher a,subject b,selectsubject c,thesis d where a.TID=b.TID and b.SubjID=c.SubjID and c.SID=d.SID and a.TID=#{TID}")
    List<Thesis> getAllTeaThesis(String TID);

    @Select("select d.ThesisID,b.Name SubName,d.Name ThesisName,e.Name StuName,d.DateTime,d.TPath\n" +
            "from teacher a,subject b,selectsubject c,thesis d,student e\n" +
            "where a.TID=b.TID and b.SubjID=c.SubjID and c.SID=d.SID and d.SID=e.SID\n" +
            "and a.TID=#{TID}")
    List<ThesisPageData> getAllTPD(String TID);

    @Select("select * from thesis where SID=#{SID} ")
    List<Thesis> getThesisListByStuID(String SID);

    @Delete("delete from thesis where TPath=#{TPath}")
    Boolean deleteFileByPath(String TPath);

    @Insert("insert into thesis (Name, TPath, DateTime, SID) values(#{Name}, #{TPath}, now(), #{SID})")
    Boolean uploadStuFile(@Param("Name")String Name, @Param("TPath")String TPath, @Param("SID")String SID);

}
