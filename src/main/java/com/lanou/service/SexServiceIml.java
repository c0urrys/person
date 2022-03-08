package com.lanou.service;

import com.lanou.bean.Sex;
import com.lanou.mapper.SexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class SexServiceIml implements SexService{
    @Autowired
    private SexMapper sexMapper;
    @Override
    public List<Sex> listAll() {
        List<Sex> list = sexMapper.listAll();
        return list;
    }
}
