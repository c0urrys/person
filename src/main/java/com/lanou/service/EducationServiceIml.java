package com.lanou.service;

import com.lanou.bean.Education;
import com.lanou.mapper.EducationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class EducationServiceIml implements EducationService{
    @Autowired
    private EducationMapper educationMapper;
    @Override
    public List<Education> listAll() {
        List<Education> list = educationMapper.listAll();
        return list;
    }
}
