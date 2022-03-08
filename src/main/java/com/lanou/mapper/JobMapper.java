package com.lanou.mapper;

import com.lanou.bean.Job;

import java.util.List;

public interface JobMapper {
    List<Job> listAll(String name);

    Job findById(Integer id);


    int add(Job job);

    int delete(Integer id);

    int update(Job job);
}
