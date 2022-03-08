package com.lanou.mapper;

import com.lanou.bean.Leave;

import java.util.List;

public interface LeaveMapper {
    List<Leave> listAll(String name);

    Leave findById(Integer id);

    int update(Leave leave);

    int delete(Integer id);
}
