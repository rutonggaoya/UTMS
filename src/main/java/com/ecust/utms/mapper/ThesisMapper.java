package com.ecust.utms.mapper;

import com.ecust.utms.model.Thesis;
import com.ecust.utms.model.ThesisPageData;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface ThesisMapper {

    @Select("select d.* from teacher a,subject b,selectsubject c,thesis d where a.TID=b.TID and b.SubjID=c.SubjID and c.SID=d.SID and a.TID=#{TID}")
    List<Thesis> getAllTeaThesis(String TID);

    @Select("select c.SSID,d.ThesisID,b.Name SubName,d.Name ThesisName,e.Name StuName,d.DateTime,d.TPath\n" +
            "from teacher a,subject b,selectsubject c,thesis d,student e\n" +
            "where a.TID=b.TID and b.SubjID=c.SubjID and c.SID=d.SID and d.SID=e.SID\n" +
            "and a.TID=#{TID} AND c.`Status` = 1 ")
    List<ThesisPageData> getAllTPD(String TID);

    @Select("select * from thesis where SID=#{SID} ")
    List<Thesis> getThesisListByStuID(String SID);

    @Delete("delete from thesis where TPath=#{TPath}")
    Boolean deleteFileByPath(String TPath);

    @Insert("insert into thesis (Name, TPath, DateTime, SID) values(#{Name}, #{TPath}, now(), #{SID})")
    Boolean uploadStuFile(@Param("Name")String Name, @Param("TPath")String TPath, @Param("SID")String SID);

    // 默认审核通过（Review取1） 默认审核人为张腾510100003
    @Insert("insert into similarityratecheck(`ThesisID`, `Review`, `SimilarityRate`, `ReviewerID`) values(#{ThesisID}, 1, #{SimilarityRate}, 510100003)")
    Boolean setSimilarityCheck(@Param("ThesisID") String ThesisID, @Param("SimilarityRate") String SimilarityRate);

    @Select("select s.ThesisID from similarityratecheck as s, thesis as t\n" +
            "where s.ThesisID = t.ThesisID and t.SID = #{SID};")
    String checkFinalSubmit(String SID);

    @Select("select SimilarityRate from similarityratecheck where ThesisID = #{ThesisID}")
    String getSimilarityRateByThesisID(String ThesisID);

    @Select("select EGrade from evaluatethesis where ThesisID = #{ThesisID}")
    String getEGradeByThesisID(String ThesisID);

    @Insert("insert into evaluatethesis(`EGrade`, `ThesisID`) values (#{EGrade}, #{ThesisID}) ")
    Boolean setScore(@Param("EGrade") String EGrade, @Param("ThesisID") String ThesisID);
}
