package com.lanou.bean;

import lombok.Data;

@Data
public class Salary {
    private Integer id;
    private Integer dept_id;
    private Integer job_id;
    private Integer emp_id;
    private Integer salary_station;
    private Integer salary_level;
    private Integer seniority_pay;
    private Integer performance;
    private Double individual_income;
    private String create_date;
    private String empname;
    private String jobname;
    private String deptname;
}
