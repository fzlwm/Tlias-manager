package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.Report;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
//    @Select("select id,username,password,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time from emp " +
//            "where name like CONCAT('%',#{name},'%') and (entry_date between #{begin} and #{end}) " +
//            "and gender =#{gender}")
    List<Emp> list(EmpQueryParam e);

    void Insert(Emp emp);

    void deleteEmp(List<Integer> ids);

    @Select("select id,username,password,name,gender,job,salary,image,entry_date,dept_id,create_time,update_time from emp")
    List<Emp> listALl();

    @Select("select id,username,password,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time from emp where id=#{id}")
    Emp selectById(Integer id);

    void update(Emp emp);

    List<Map<String,Object>> empJobData();

    List<Map<String, Object>> empGenderData();

    @Select("select id,username,name from emp where username=#{username} and password=#{password}")
    LoginInfo login(Emp emp);
}
