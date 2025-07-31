package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface EmpExprMapper {

    void Insert(List<EmpExpr> exprList);

    void deleteExpr(List<Integer> ids);

    @Select("select id, begin, end, company, job, emp_id from emp_expr where emp_id=#{id}")
    ArrayList<EmpExpr> listByEmpId(Integer id);
}
