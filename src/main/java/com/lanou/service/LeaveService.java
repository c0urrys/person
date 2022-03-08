package com.lanou.service;

import com.lanou.bean.Leave;

import java.util.List;

public interface LeaveService {
    List<Leave> listAll(String name);

    Leave findById(Integer id);

    int update(Leave leave);

    int delete(Integer id);
}
