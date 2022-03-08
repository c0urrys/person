package com.lanou.service;

import com.lanou.bean.Uservisit;
import com.lanou.mapper.UserVisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class UserVisitServiceIml implements UserVisitService{
    @Autowired
    private UserVisitMapper userVisitMapper;
    @Override
    public List<Uservisit> listAll(String name) {
        List<Uservisit> list = userVisitMapper.listAll(name);
        return list;
    }

    @Override
    public int delete(Integer id) {
        int i = userVisitMapper.delete(id);
        return i;
    }
}
