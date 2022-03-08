package com.lanou.service;

import com.lanou.bean.Business;
import com.lanou.mapper.BusinessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceIml implements BusinessService{

    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public List<Business> listAll() {
        List<Business> list = businessMapper.listAll();
        return list;
    }
}
