package com.lanou.service;

import com.lanou.bean.Job;
import com.lanou.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class JobServiceIml implements JobService{
    @Autowired
    private JobMapper jobMapper;
    @Override
    public List<Job> listAll(String name) {
        List<Job> list = jobMapper.listAll(name);
        return list;
    }

    @Override
    public int add(Job job) {
        int i = jobMapper.add(job);
        return i;
    }

    @Override
    public int delete(Integer id) {
        int i = jobMapper.delete(id);
        return i;
    }

    @Override
    public int update(Job job) {
        int i = jobMapper.update(job);
        return i;
    }

    @Override
    public Job findById(Integer id) {
        Job job = jobMapper.findById(id);
        return job;
    }
}
