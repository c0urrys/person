package com.lanou.service;

import com.lanou.bean.Uservisit;

import java.util.List;

public interface UserVisitService {
    List<Uservisit> listAll(String name);

    int delete(Integer id);
}
