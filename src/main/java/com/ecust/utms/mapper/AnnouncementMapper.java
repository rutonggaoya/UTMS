package com.ecust.utms.mapper;

import com.ecust.utms.model.Announcement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnnouncementMapper {

    @Select("select * from announcement")
    List<Announcement> getAllAn();

    @Select("select * from announcement where AID=#{AID}")
    Announcement getAn(Integer AID);

//    @Options(useGeneratedKeys = true,keyProperty = "AID")
    @Insert("insert into announcement(`Content`, `Title`, `DateTime`, `PubID`, `ReadNum`) values(#{Content},#{Title},now(),#{PubID},0)")
    int insertAn(@Param("Content") String Content, @Param("Title") String Title, @Param("PubID") String PubID);

    @Delete("delete from announcement where AID={#AID}")
    int deleteAn(Integer AID);

    @Update("update announcement set Content=#{Content},Title=#{Title},DateTime=#{DateTime},PubID=#{PubID},ReadNum=#{ReadNum} where AID={#AID}")
    int updateAn(Announcement announcement);

}
