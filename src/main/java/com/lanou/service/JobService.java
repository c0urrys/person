package com.lanou.service;

import com.lanou.bean.Job;

import java.util.List;

public interface JobService {
    List<Job> listAll(String name);

    int add(Job job);

    int delete(Integer id);

    int update(Job job);

    Job findById(Integer id);
}
