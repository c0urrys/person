package com.lanou.service;

import com.lanou.bean.Train;

import java.util.List;

public interface TrainService {
    List<Train> listAll(String name);

    Train findById(Integer id);

    int insert(Train train);

    int update(Train train);

    int delete(Integer id);
}
