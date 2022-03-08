package com.lanou.service;

import com.lanou.bean.Status;
import com.lanou.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class StatusServiceIml implements StatusService {
    @Autowired
    private StatusMapper statusMapper;
    @Override
    public List<Status> listAll() {
        List<Status> list = statusMapper.listAll();
        return list;
    }
}
