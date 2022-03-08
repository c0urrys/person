package com.lanou.bean;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String loginname;
    private String password;
    private String email;
    private Integer status_id;
    private String createdate;
    private String username;
    private Integer emp_id;
    private Integer che_id;
    private Integer con_id;
    private Integer sal_id;
    private List<Status> statusList;
}
