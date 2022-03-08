package com.lanou.mapper;


import com.lanou.bean.Contract;

import java.util.List;

public interface ContractMapper {
    List<Contract> listAll(String name);

    Contract findById(Integer id);

    int add(Contract contract);

    int update(Contract contract);
}
