package com.lanou.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class JobData implements Serializable {
    private String name;
    private Integer value;
}
