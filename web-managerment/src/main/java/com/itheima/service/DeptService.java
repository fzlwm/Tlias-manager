package com.itheima.service;

import com.itheima.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    List<Dept> findAll();

    void delete(Integer id);

    void Insert(Dept dept);

    Dept SelectById(Integer id);

    void Update(Dept dept);
}
