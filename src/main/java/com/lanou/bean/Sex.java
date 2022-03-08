package com.lanou.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sex implements Serializable {
    private Integer id;
    private String name;
    private Integer value;
}
