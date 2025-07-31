package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
//id,name,room,begin_date,end_date,master_id,subject,create_time,update_time
public class Clazz {
    private Integer id;
    private String name;
    private String room;
    private LocalDate beginDate;//开课时间
    private LocalDate endDate;//结课时间
    private Integer masterId;
    private Integer subject;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
