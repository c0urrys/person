package com.lanou.web;

import com.alibaba.fastjson.JSONObject;
import com.lanou.bean.Emp;
import com.lanou.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class StaticidController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/statistics")
    public String statistics(){

        return "statistics/statistics";
    }


}
