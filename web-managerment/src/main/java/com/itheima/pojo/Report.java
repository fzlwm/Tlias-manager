package com.itheima.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Report {
    List<String> jobList = new ArrayList<>();
    List<Long> dataList = new ArrayList<>();
}
