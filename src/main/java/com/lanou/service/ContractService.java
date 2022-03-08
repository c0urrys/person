package com.lanou.service;

import com.lanou.bean.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> listAll(String name);

    Contract findById(Integer id);

    int add(Contract contract);

    int update(Contract contract);
}
