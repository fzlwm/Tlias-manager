package com.itheima.service;

import com.itheima.pojo.Report;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReportService {

    Report empJobData();

    List<Map<String, Object>> empGenderData();
}
