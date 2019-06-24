package com.ecust.utms.mapper;

import com.ecust.utms.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where DeptID=#{DeptID}")
    Department getDept(Integer DeptID);

    @Select("select * from department")
    List<Department> getAllDept();
}
