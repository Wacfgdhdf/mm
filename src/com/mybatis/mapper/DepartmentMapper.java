package com.mybatis.mapper;

import com.mybatis.entities.Department;

public interface DepartmentMapper {
    Department getDepartmentMapperByid(Integer id);
    //查询部门的同时将部门下的所有的员工都查出来
    Department getDepartmentContainEmps(Integer id);
    Department getDepartmentContainEmpsBystep(Integer id);
}
