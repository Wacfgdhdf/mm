package com.mybatis.test;

import com.mybatis.entities.Department;
import com.mybatis.entities.Employee;
import com.mybatis.mapper.DepartmentMapper;
import com.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        //通过xml配置sqlsession对象
        String resource = "mybatis-config.xml";
        //读取mybatis的全局配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sqlsessionfactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        return build;
    }
    @Test
    public void testgetEmployee() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employeeById = mapper.getEmployeeById(3);
            System.out.println(employeeById);
        }finally {
            sqlSession.close();
        }
}

    @Test
    public void getEmployeeByLastnameandemail()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee wang = mapper.getEmployeeByLastnameandemail("chen", "baidu@qq.com");
            System.out.println(wang);
        }finally {
            sqlSession.close();
        }
    }

    public void addEmployee()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            //获取映射文件的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
           // mapper.addEmployee(new Employee(null,"lv","lv@qq.com",2000.0,1));
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getEmployeeByMap()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, String> map = new HashMap<>();
            map.put("ls", "wang");
            map.put("em", "baidu@qq.com");
            Employee employeeByMap = mapper.getEmployeeByMap(map);
            System.out.println(employeeByMap);

        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void getEmployees()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.getEmployees();
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void getMapEmployees()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Employee> mapEmployees = mapper.getMapEmployees(3);
            System.out.println(mapEmployees);
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void getMapAllEmployees()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<Integer, Employee> mapAllEmployees = mapper.getMapAllEmployees();
            System.out.println(mapAllEmployees);
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void getEmployeeContainDept()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employeeContainDept = mapper.getEmployeeContainDept(3);
            System.out.println(employeeContainDept);
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void getEmployeeContainDeptbystep()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employeeContainDeptbystep = mapper.getEmployeeContainDeptbystep(3);
            System.out.println(employeeContainDeptbystep);
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void getDepartmentContainEmps()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department departmentContainEmps = mapper.getDepartmentContainEmps(2);
            System.out.println(departmentContainEmps.getId());
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void getDepartmentContainEmpsBystep()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department departmentContainEmpsBystep = mapper.getDepartmentContainEmpsBystep(2);
            System.out.println(departmentContainEmpsBystep);

        } finally {
            sqlSession.close();
        }

    }
    //测试动态sql
    @Test
    public void getEmployeeContitionIf()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取映射文件的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee marry = new Employee(null, "marry", "ali@qq.com", null,null);
            Employee employeeContitionIf = mapper.getEmployeeContitionIf(marry);
            System.out.println(employeeContitionIf);

        } finally {
            sqlSession.close();
        }

    }
}
