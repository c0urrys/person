package com.lanou.service;

import com.lanou.bean.Salary;
import com.lanou.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class SalaryServiceIml implements SalaryService{

    @Autowired
    private SalaryMapper salaryMapper;
    @Override
    public List<Salary> listAll(String name) {
        List<Salary> list = salaryMapper.listAll(name);
        return list;
    }

    @Override
    public Salary findById(Integer id) {
        Salary salary = salaryMapper.findById(id);
        return salary;
    }

    @Override
    public int add(Salary salary) {
        int i = salaryMapper.add(salary);
        return i;
    }

    @Override
    public int update(Salary salary) {
        int i = salaryMapper.update(salary);
        return i;
    }
}
