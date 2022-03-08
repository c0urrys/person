package com.lanou.service;

import com.lanou.bean.CheckWork;
import com.lanou.mapper.CheckWorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class CheckWorkServiceIml implements CheckWorkService{

    @Autowired
    private CheckWorkMapper checkWorkMapper;

    @Override
    public List<CheckWork> listAll(String name) {
        List<CheckWork> list = checkWorkMapper.listAll(name);
        return list;
    }

    @Override
    public CheckWork findById(Integer id) {
        CheckWork checkWork = checkWorkMapper.findById(id);
        return checkWork;
    }

    @Override
    public int add(CheckWork checkWork) {
        int i = checkWorkMapper.add(checkWork);
        return i;
    }

    @Override
    public int update(CheckWork checkWork) {
        int i = checkWorkMapper.update(checkWork);
        return i;
    }
}
