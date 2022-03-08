package com.lanou.service;

import com.lanou.bean.Completion;

import com.lanou.mapper.CompletionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompletionServiceIml implements CompletionService{

    @Autowired
    private CompletionMapper completionMapper;
    @Override
    public List<Completion> listAll() {
        List<Completion> list = completionMapper.listAll();
        return list;
    }
}
