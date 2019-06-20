package com.ecust.utms.mapper;

import com.ecust.utms.model.Attachment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttachmentMapper {

    @Select("select * from attachmen")
    List<Attachment> getAllAt();

    @Select("select * from attachment where AID=#{AID}")
    List<Attachment> getAtByAID(Integer AID);

    @Select("select * from attachment where ATID=#{ATID}")
    Attachment getAtByATID(Integer ATID);

    @Options(useGeneratedKeys = true,keyProperty = "ATID")
    @Insert("insert into attachment values (ATPath=#{ATPath},AID=#{AID}")
    int insertAt(Attachment attachment);

}
