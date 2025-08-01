package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void Insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.Insert(dept);
    }

    @Override
    public Dept SelectById(Integer id) {
        return deptMapper.SelectById(id);
    }

    @Override
    public void Update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
         deptMapper.Update(dept);
    }

}
