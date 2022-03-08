package com.lanou.service;

import com.lanou.bean.Train;
import com.lanou.mapper.TrainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainServiceIml implements TrainService{
    @Autowired
    private TrainMapper trainMapper;
    @Override
    public List<Train> listAll(String name) {
        List<Train> list = trainMapper.listAll(name);
        return list;
    }

    @Override
    public Train findById(Integer id) {
        Train train = trainMapper.findById(id);
        return train;
    }

    @Override
    public int insert(Train train) {
        int i = trainMapper.insert(train);
        return i;
    }

    @Override
    public int update(Train train) {
        int i = trainMapper.update(train);
        return i;
    }

    @Override
    public int delete(Integer id) {
        int i = trainMapper.delete(id);
        return i;
    }
}
