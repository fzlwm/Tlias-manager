package com.itheima.controller;

import com.itheima.pojo.Report;
import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @GetMapping("/empJobData")
    public Result empJobData(){

        Report report =reportService.empJobData();
        return Result.success(report);
    }
    @GetMapping("/empGenderData")
    public Result empGenderData(){
        List<Map<String,Object>> genderList=reportService.empGenderData();
        return Result.success(genderList);
    }
}
