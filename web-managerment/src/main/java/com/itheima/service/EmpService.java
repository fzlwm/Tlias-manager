package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.ResultPage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {
    ResultPage<Emp> list(EmpQueryParam empQueryParam);

    void Insert(Emp emp);

    void delete(List<Integer> ids);

    List<Emp> listALl();

    Emp selectById(Integer id);

    void update(Emp emp);

    LoginInfo login(Emp emp);
}
