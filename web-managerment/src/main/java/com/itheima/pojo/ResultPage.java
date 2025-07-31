package com.itheima.pojo;

import lombok.Data;

import java.util.List;
@Data
public class ResultPage<T> {
    private long total;
    private List<T> rows;
}
