package com.itheima.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmpQueryParam {
    private Integer page;
    private Integer pageSize;
    private String name;
    private Integer gender;
    //hh:mm:ss的时间格式begin
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDate begin;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDate end;
}
