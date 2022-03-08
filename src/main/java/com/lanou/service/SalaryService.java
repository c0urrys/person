package com.lanou.service;

import com.lanou.bean.Salary;

import java.util.List;

public interface SalaryService {
    List<Salary> listAll(String name);

    Salary findById(Integer id);

    int add(Salary salary);

    int update(Salary salary);
}
