package com.lanou.mapper;

import com.lanou.bean.CheckWork;


import java.util.List;

public interface CheckWorkMapper {
    List<CheckWork> listAll(String name);

    CheckWork findById(Integer id);

    int add(CheckWork checkWork);

    int update(CheckWork checkWork);
}
