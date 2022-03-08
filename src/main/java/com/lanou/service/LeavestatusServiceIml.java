package com.lanou.service;

import com.lanou.bean.Leavestatus;
import com.lanou.mapper.LeavestatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class LeavestatusServiceIml implements LeavestatusService{

    @Autowired
    private LeavestatusMapper leavestatusMapper;
    @Override
    public List<Leavestatus> listAll() {
        List<Leavestatus> list = leavestatusMapper.listAll();
        return list;
    }
}
