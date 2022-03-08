package com.lanou.service;

import com.lanou.bean.Leave;
import com.lanou.mapper.LeaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class LeaveServiceIml implements LeaveService{

    @Autowired
    private LeaveMapper leaveMapper;
    @Override
    public List<Leave> listAll(String name) {
        List<Leave> list = leaveMapper.listAll(name);
        return list;
    }

    @Override
    public Leave findById(Integer id) {
        Leave leave = leaveMapper.findById(id);
        return leave;
    }

    @Override
    public int update(Leave leave) {
        int i = leaveMapper.update(leave);
        return i;
    }

    @Override
    public int delete(Integer id) {
        int i = leaveMapper.delete(id);
        return i;
    }
}
