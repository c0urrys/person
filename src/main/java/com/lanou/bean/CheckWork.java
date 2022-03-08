package com.lanou.bean;

import lombok.Data;

@Data
public class CheckWork {
    private String id;
    private Integer dept_id;
    private String deptname;
    private Integer job_id;
    private String jobname;
    private Integer emp_id;
    private String empname;
    private Integer workingdays;
    private Integer daysleave;
    private String createdate;
    private Integer daysout;

}
