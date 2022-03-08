package com.lanou.mapper;

import com.lanou.bean.Uservisit;

import java.util.List;

public interface UserVisitMapper {
    List<Uservisit> listAll(String name);

    int delete(Integer id);
}
