package com.ecust.utms.mapper;

import com.ecust.utms.model.AnswerIntroData;
import com.ecust.utms.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Select("select * from question order by DateTime desc")
    List<Question> getAllQue();

    @Select("SELECT b.AnswerID,a.Content QueContent,b.Content AnsContent,b.DateTime \n" +
            "FROM question a,answer b\n" +
            "where a.QID=b.QID and b.RespondentID=#{TID}")
    List<AnswerIntroData> getMyAnswer(String TID);
}
