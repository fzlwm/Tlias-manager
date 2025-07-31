package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Report;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private EmpMapper empMapper;
    @Override
    public Report empJobData() {
        List<Map<String, Object>> rawData = empMapper.empJobData();
        Report report = new Report();
        for (Map<String, Object> row : rawData) {
            // 把每行的jobName值加到集合中
            report.getJobList().add((String) row.get("jobName"));
            // 把每行的sum值加到集合中
            report.getDataList().add((Long) row.get("sum"));
        }
        return report;
    }

    @Override
    public List<Map<String, Object>> empGenderData() {
        List<Map<String, Object>> genderList = empMapper.empGenderData();
        return genderList;
    }
}
