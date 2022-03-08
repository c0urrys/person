package com.lanou.service;

import com.lanou.bean.Traindata;
import com.lanou.mapper.TraindataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TraindataServiceIml implements TraindataService{

    @Autowired
    private TraindataMapper traindataMapper;
    @Override
    public List<Traindata> listAll(String name) {
        List<Traindata> list = traindataMapper.listAll(name);
        return list;
    }

    @Override
    public Traindata findById(Integer id) {
        Traindata traindata = traindataMapper.findById(id);
        return traindata;
    }

    @Override
    public int insert(Traindata traindata) {
        int i = traindataMapper.insert(traindata);
        return i;
    }

    @Override
    public int update(Traindata traindata) {
        int i = traindataMapper.update(traindata);
        return i;
    }

    @Override
    public int delete(Integer id) {
        int i = traindataMapper.delete(id);
        return i;
    }
}
