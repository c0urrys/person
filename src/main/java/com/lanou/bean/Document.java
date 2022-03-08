package com.lanou.bean;

import lombok.Data;

@Data
public class Document {
    private Integer id;
    private String title;
    private String filename;
    private String remark;
    private String createdate;
    private Integer user_id;
    private String username;
}
