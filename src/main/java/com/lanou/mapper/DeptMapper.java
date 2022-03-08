package com.lanou.mapper;

import com.lanou.bean.Dept;

import java.util.List;

public interface DeptMapper {
    List<Dept> listAll(String name);

    Dept findById(Integer id);

    int insert(Dept dept);

    int update(Dept dept);

    int delete(Integer id);
}
