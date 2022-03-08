package com.lanou.bean;

import lombok.Data;

@Data
public class Leave {
    private Integer id;
    private Integer emp_id;
    private String empname;
    private Integer dept_id;
    private String deptname;
    private Integer job_id;
    private String jobname;
    private String startdata;
    private String enddata;
    private String leavedays;
    private String content;
    private Integer leavestatus;
    private String leavestatusname;
    private String leavetime;
    private Integer leavetype;
    private String leavetypename;


}
