package com.lanou.service;

import com.lanou.bean.Leavetype;
import com.lanou.mapper.LeavetypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class LeavetypeServiceIml implements LeavetypeService{

    @Autowired
    private LeavetypeMapper leavetypeMapper;
    @Override
    public List<Leavetype> listAll() {
        List<Leavetype> list = leavetypeMapper.listAll();
        return list;
    }
}
