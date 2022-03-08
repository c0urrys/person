package com.lanou.bean;

import lombok.Data;

@Data
public class Notice {
    private Integer id;
    private String title;
    private String content;
    private String createdate;
    private Integer user_id;
    private String username;
}
