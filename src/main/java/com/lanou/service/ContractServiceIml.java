package com.lanou.service;

import com.lanou.bean.Contract;
import com.lanou.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ContractServiceIml implements ContractService{

    @Autowired
    private ContractMapper contractMapper;
    @Override
    public List<Contract> listAll(String name) {
        List<Contract> list = contractMapper.listAll(name);
        return list;
    }

    @Override
    public Contract findById(Integer id) {
        Contract contract = contractMapper.findById(id);
        return contract;
    }

    @Override
    public int add(Contract contract) {
        int i = contractMapper.add(contract);
        return i;
    }

    @Override
    public int update(Contract contract) {
        int i = contractMapper.update(contract);
        return i;
    }
}
