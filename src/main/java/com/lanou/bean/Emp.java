package com.lanou.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer dept_id;
    private String deptname;
    private Integer job_id;
    private String jobname;
    private String name;
    private String card_id;
    private String address;
    private String phone;
    private Integer sex_id;
    private String sex;
    private Integer education_id;
    private String educationname;
    private String createdate;
    private Integer user_id;
    private String username;
    private String useremail;

}
