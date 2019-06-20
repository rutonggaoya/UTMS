package com.ecust.utms.mapper;

import com.ecust.utms.model.Answer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnswerMapper {

    @Select("select * from answer")
    List<Answer> getAllAns();

    @Select("select * from answer where AnswerId={#AnswerID}")
    Answer getAns(Integer AnswerID);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into answer values(#{DateTime},#{Content},#{QID},#{RespondentID})")
    int insertAns(Answer answer);

    @Delete("delete from answer where AnswerID=#{AnswerID}")
    int deleteAns(Integer AnswerID);

    @Update("update answer set DateTime=#{DateTime},Content=#{Content},QID=#{QID},RespondentID=#{RespondentID} where AnswerID=#{AnswerID}")
    int updateAns(Answer answer);

}
