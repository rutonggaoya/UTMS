package com.ecust.utms.mapper;

import com.ecust.utms.model.Answer;
import com.ecust.utms.model.AnswerIntroData;
import com.ecust.utms.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Select("select * from question order by DateTime desc")
    List<Question> getAllQue();

    @Select("SELECT b.AnswerID,a.Content QueContent,b.Content AnsContent,b.DateTime \n" +
            "FROM question a,answer b\n" +
            "where a.QID=b.QID and b.RespondentID=#{TID}")
    List<AnswerIntroData> getMyAnswerByTID(String TID);

    @Select("SELECT b.AnswerID,a.Content QueContent,b.Content AnsContent,b.DateTime \n" +
            "FROM question a,answer b\n" +
            "where a.QID=b.QID and b.RespondentID=#{SID}")
    List<AnswerIntroData> getMyAnswerBySID(String SID);

    @Select("select q.Content as `Content`, q.DateTime as `Datetime`, q.`Desc` as `Desc`, q.QID as `QID`, q.SID as `SID`\n" +
            "from question as q\n" +
            "where SID = #{SID}\n")
    List<Question> getMyQuestionBySID(String SID);

    @Select("select * from question where QID=#{QID} limit 1")
    Question getQuestionByQID(String QID);

    @Insert("insert into question(`Content`, `Desc`, `DateTime`, `SID`) values(#{Content}, #{Desc}, now(), #{SID})")
    Boolean insertQuestion(@Param("Content") String Content, @Param("Desc") String Desc, @Param("SID") String SID);
}
