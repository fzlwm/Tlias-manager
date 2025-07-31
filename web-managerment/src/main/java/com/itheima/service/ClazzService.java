package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.ResultPage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClazzService {
    List<Clazz> listAll();

    ResultPage<Clazz> list(EmpQueryParam empQueryParam);
}
