package com.lanou.service;

import com.lanou.bean.Traindata;

import java.util.List;

public interface TraindataService {
    List<Traindata> listAll(String name);

    Traindata findById(Integer id);

    int insert(Traindata traindata);

    int update(Traindata traindata);

    int delete(Integer id);
}
