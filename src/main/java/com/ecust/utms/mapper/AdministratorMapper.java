package com.ecust.utms.mapper;

import com.ecust.utms.model.Administrator;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdministratorMapper {

    @Select("select * from administrator")
    List<Administrator> getAllAd();

    @Select("select * from administrator where TID=#{TID}")
    Administrator getAd(String TID);

    //@Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into administrator values (#{TID},#{Name},#{Gender},#{Passwd},#{Tel},#{Email},#{DeptID})")
    int insertAd(Administrator administrator);

    @Delete("delete from administrator where TID=#{TID}")
    int deleteAd(String TID);

    @Update("update administrator set Name=#{Name},Gender=#{Gender},Passwd=#{Passwd},Tel=#{Tel},Email=#{Email},DeptID=#{DeptID} where TID={#TID}")
    int updateAd(Administrator administrator);

}
