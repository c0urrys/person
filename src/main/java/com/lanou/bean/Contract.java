package com.lanou.bean;

import lombok.Data;

@Data
public class Contract {
    private Integer id;
    private Integer dept_id;
    private String deptname;
    private Integer job_id;
    private String jobname;
    private Integer status_id;
    private String statusname;
    private Integer emp_id;
    private String empname;
    private Integer train_contract;
    private Integer labor_contract;
    private String create_date;
    private Integer confidentiality_contract;
}
