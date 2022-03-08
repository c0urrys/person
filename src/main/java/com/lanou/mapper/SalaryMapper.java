package com.lanou.mapper;

import com.lanou.bean.Salary;
import com.lanou.bean.User;

import java.util.List;

public interface SalaryMapper {
    List<Salary> listAll(String name);

    Salary findById(Integer id);

    int add(Salary salary);

    int update(Salary salary);

}
