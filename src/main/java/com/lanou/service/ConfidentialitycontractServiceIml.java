package com.lanou.service;

import com.lanou.bean.Confidentialitycontract;
import com.lanou.mapper.ConfidentialitycontractMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class ConfidentialitycontractServiceIml implements ConfidentialitycontractService{

    @Autowired
    private ConfidentialitycontractMappper confidentialitycontractMappper;

    @Override
    public List<Confidentialitycontract> listAll() {
        List<Confidentialitycontract> list = confidentialitycontractMappper.listAll();
        return list;
    }
}
