package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.*;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Override
    public ResultPage<Emp> list(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> list = empMapper.list(empQueryParam);
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        ResultPage<Emp> resultPage = new ResultPage<>();
        resultPage.setTotal(pageInfo.getTotal());
        resultPage.setRows(list);
        return resultPage;
    }
    @Transactional
    @Override
    public void Insert(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.Insert(emp);
        List<EmpExpr> exprList = emp.getExprList();
        //判断非空
        if(exprList != null && !exprList.isEmpty()) {
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.Insert(exprList);
        }
    }

    @Transactional
    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteEmp(ids);
        empExprMapper.deleteExpr(ids);
    }

    @Override
    public List<Emp> listALl() {
        empMapper.listALl();
        return empMapper.listALl();
    }

    @Override
    public Emp selectById(Integer id) {
        Emp emp = empMapper.selectById(id);
        emp.setExprList(empExprMapper.listByEmpId(id));
        return emp;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        List<EmpExpr> exprList = emp.getExprList();
        //判断非空
        if(exprList != null && !exprList.isEmpty()) {
            empExprMapper.deleteExpr(Collections.singletonList(emp.getId()));
            empExprMapper.Insert(exprList);
        }
    }

    @Override
    public LoginInfo login(Emp emp){
        LoginInfo loginInfo = empMapper.login(emp);
        if(loginInfo != null) {
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginInfo.getId());
            claims.put("username",loginInfo.getUsername());
            loginInfo.setToken(JwtUtils.generateToken(claims));
        }
        else {
            throw new RuntimeException("用户名或密码错误");
        }
        return loginInfo;
    }
}
