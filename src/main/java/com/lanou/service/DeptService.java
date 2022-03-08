package com.lanou.service;

import com.lanou.bean.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> listAll(String name);

    int insert(Dept dept);

    int update(Dept dept);

    Dept findById(Integer id);

    int delete(Integer id);
}
