package com.itheima.controller;

import com.itheima.pojo.*;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping("/list")
    public Result listAll() {
        List<Clazz> clazzList =clazzService.listAll();
        return Result.success(clazzList);
    }
    @GetMapping
    public Result list(EmpQueryParam empQueryParam) {
        ResultPage<Clazz> resultPage= clazzService.list(empQueryParam);
        return Result.success(resultPage);
    }

}
