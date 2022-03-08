package com.lanou.web;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Business;
import com.lanou.bean.Emp;
import com.lanou.bean.JobData;
import com.lanou.service.BusinessService;
import com.lanou.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class EchartsData {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BusinessService businessService;


    @RequestMapping("/echartsData")
    @ResponseBody
    public List<JobData> echartsData(){
        List<Emp> list = employeeService.listAll(null);
        Integer man = 0;
        Integer men = 0;
        for (Emp emp : list
             ) {
            if(emp.getSex_id()==1){
                man += 1;
            }else {
                men +=1;
            }
        }
       List<JobData> jobDataList = new ArrayList<>();
        JobData jobData1 = new JobData();
        jobData1.setName("男");
        jobData1.setValue(man);
        JobData jobData2 = new JobData();
        jobData2.setName("女");
        jobData2.setValue(men);
        jobDataList.add(jobData1);
        jobDataList.add(jobData2);
        return jobDataList;
    }

    @RequestMapping("/echartsData1")
    @ResponseBody
    public List<JobData> echartsData1(){
        List<Emp> list = employeeService.listAll(null);
        Integer temp1 = 0;
        Integer temp2 = 0;
        Integer temp3 = 0;


        for (Emp emp : list
        ) {
            if(emp.getDept_id()==1){
                temp1 += 1;
            }
            if(emp.getDept_id()==3){
                temp2 += 1;
            }
            if(emp.getDept_id()==7){
                temp3 += 1;
            }
        }
        List<JobData> jobDataList = new ArrayList<>();
        JobData jobData1 = new JobData();
        jobData1.setName("技术部");
        jobData1.setValue(temp1);
        JobData jobData2 = new JobData();
        jobData2.setName("财务部");
        jobData2.setValue(temp2);
        JobData jobData3 = new JobData();
        jobData3.setName("教学部");
        jobData3.setValue(temp3);
        jobDataList.add(jobData1);
        jobDataList.add(jobData2);
        jobDataList.add(jobData3);
        return jobDataList;
    }

    @RequestMapping("/echartsData2")
    @ResponseBody
    public List<Business> echartsData2(){

        List<Business> list1 = businessService.listAll();
        return list1;
    }

    @RequestMapping("/echartsData3")
    @ResponseBody
    public List<JobData> echartsData3(){

        List<Emp> list = employeeService.listAll(null);
        Integer temp1 = 0;
        Integer temp2 = 0;
        Integer temp3 = 0;
        Integer temp4 = 0;
        Integer temp5 = 0;
        Integer temp6 = 0;

        for (Emp emp : list
        ) {
            if(emp.getAddress().equals("浙江省温州市")){
                temp1 += 1;
            }
            if(emp.getAddress().equals("江苏省南京市")){
                temp2 += 1;
            }
            if(emp.getAddress().equals("甘肃省兰州市")){
                temp3 += 1;
            }
            if(emp.getAddress().equals("甘肃省兰州市")){
                temp4 += 1;
            }
            if(emp.getAddress().equals("太阳之上")){
                temp5 += 1;
            }
            if(emp.getAddress().equals("河南省郑州市")){
                temp6 += 1;
            }

        }
        List<JobData> jobDataList = new ArrayList<>();
        JobData jobData1 = new JobData();
        jobData1.setName("浙江");
        jobData1.setValue(temp1);
        JobData jobData2 = new JobData();
        jobData2.setName("江苏");
        jobData2.setValue(temp2);
        JobData jobData3 = new JobData();
        jobData3.setName("甘肃");
        jobData3.setValue(temp3);
        JobData jobData4 = new JobData();
        jobData4.setName("北京");
        jobData4.setValue(temp4);
        JobData jobData5 = new JobData();
        jobData5.setName("太阳之上");
        jobData5.setValue(temp5);
        JobData jobData6 = new JobData();
        jobData6.setName("河南");
        jobData6.setValue(temp6);
        jobDataList.add(jobData1);
        jobDataList.add(jobData2);
        jobDataList.add(jobData3);
        jobDataList.add(jobData4);
        jobDataList.add(jobData5);
        jobDataList.add(jobData6);

        return jobDataList;
    }
}
