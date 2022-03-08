package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.*;
import com.lanou.service.*;
import com.lanou.util.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SexService service;

    @Autowired
    private EducationService educationService;

    @Autowired
    private JobService jobService;

    @Autowired
    private DeptService deptService;

    @RequestMapping("list")
    public String list(String content, HttpServletRequest request, PageModel pageModel){
        PageHelper.startPage(pageModel.getPageIndex(), pageModel.getPageSize());
        List<Emp> list = employeeService.listAll(content);
        PageInfo info = new PageInfo(list);
        pageModel.setRecordCount((int)info.getTotal());
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageModel.getRecordCount());
        request.setAttribute("hre","employee/list");
        request.setAttribute("content",content);
        return "employee/list";
    }
    @RequestMapping("/toadd")
    public String toadd(HttpServletRequest request){
        List<Sex> sexList = service.listAll();
        List<Education> educationList = educationService.listAll();
        List<Job> jobList = jobService.listAll(null);
        List<Dept> deptList = deptService.listAll(null);
        request.setAttribute("sex_list",sexList);
        request.setAttribute("education_list",educationList);
        request.setAttribute("job_list",jobList);
        request.setAttribute("dept_list",deptList);
        return "employee/add";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request,Emp emp){
            int i = employeeService.add(emp);
            return "employee/list";
    }

    @RequestMapping("/toedit")
    public String toedit(HttpServletRequest request,Integer id){
        List<Sex> sexList = service.listAll();
        List<Education> educationList = educationService.listAll();
        List<Job> jobList = jobService.listAll(null);
        List<Dept> deptList = deptService.listAll(null);
        Emp emp = employeeService.findById(id);
        request.setAttribute("sex_list",sexList);
        request.setAttribute("education_list",educationList);
        request.setAttribute("job_list",jobList);
        request.setAttribute("dept_list",deptList);
        request.setAttribute("employee",emp);
        return "employee/edit";
    }

    @RequestMapping("/edit")
    public String edit(Emp employee, HttpSession session,Integer education_id,
                       Integer sex_id,Integer job_id,Integer dept_id){

        employee.setDept_id(dept_id);
        employee.setJob_id(job_id);
        employee.setEducation_id(education_id);
        employee.setSex_id(sex_id);
        employeeService.update(employee);
        session.setAttribute("employee",employee);
        return "redirect:employee/list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        int i = employeeService.delete(id);
        return "redirect:employee/list";
    }
    @RequestMapping("/topiliang")
    public String topiliang(){

        return "employee/pladd";
    }
    @RequestMapping("/piliang")
    public String addList(MultipartFile file){
        int i = employeeService.importExcel(file);
        return "redirect:/employee/list";
    }
    @RequestMapping("/toshuoming")
    public String toshuming(){
        return "employee/plist";
    }
}
