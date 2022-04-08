package com.mybatis.mapper;

import com.mybatis.entities.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    Employee getEmployeeById(Integer id);
    Employee getEmployeeByLastnameandemail(@Param("lastname")String lastname,@Param("email") String email);
    void addEmployee(Employee employee);
    Employee getEmployeeByMap(Map<String,String> map);
    List<Employee>  getEmployees();
    //map中的key是数据库中的字段名，值就是字段对应的值
    Map<String,Employee>  getMapEmployees(Integer id);
    //当用map返回多个时，要用@MapKey("id")注解指定要返回的多个Employee对象中的key是数据库中的那个字段
    @MapKey("id")
    Map<Integer,Employee>  getMapAllEmployees();
    Employee getEmployeeContainDept(Integer id);
    Employee getEmployeeContainDeptbystep(Integer id);
    List<Employee>  getEmployeesBydept(Integer id);
    Employee getEmployeeContitionIf(Employee employee);
}
