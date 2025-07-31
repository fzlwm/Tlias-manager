package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {
    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz")
    List<Clazz> listAll();
    List<Clazz> list(EmpQueryParam clazzQueryParam);
}
