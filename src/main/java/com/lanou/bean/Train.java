package com.lanou.bean;

import lombok.Data;

@Data
public class Train {
    private Integer id;
    private Integer dept_id;
    private String deptname;
    private Integer job_id;
    private String jobname;
    private Integer emp_id;
    private String empname;
    private String content;
    private String startdata;
    private String enddata;
    private Integer totallength;
    private Integer completion;
    private String completionname;
    private Integer grade;
    private String traintime;
}
