package com.lanou.service;

import com.lanou.bean.Dept;
import com.lanou.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class DeptServiceIml implements DeptService{
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> listAll(String name) {
        List<Dept> list = deptMapper.listAll(name);
        return list;
    }

    @Override
    public int insert(Dept dept) {
        int i = deptMapper.insert(dept);
        return i;
    }

    @Override
    public int update(Dept dept) {
        int i = deptMapper.update(dept);
        return i;
    }

    @Override
    public Dept findById(Integer id) {
        Dept dept = deptMapper.findById(id);
        return dept;
    }

    @Override
    public int delete(Integer id) {
        int i = deptMapper.delete(id);
        return i;
    }
}
