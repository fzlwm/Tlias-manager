package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.ResultPage;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public List<Clazz> listAll() {
       return clazzMapper.listAll();
    }

    @Override
    public ResultPage<Clazz> list(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Clazz> list = clazzMapper.list(empQueryParam);
        PageInfo<Clazz> pageInfo = new PageInfo<>(list);
        ResultPage<Clazz> resultPage = new ResultPage<>();
        resultPage.setTotal(pageInfo.getTotal());
        resultPage.setRows(list);
        return resultPage;
    }
}
