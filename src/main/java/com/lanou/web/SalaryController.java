package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.CheckWork;
import com.lanou.bean.Dept;
import com.lanou.bean.Job;
import com.lanou.bean.Salary;
import com.lanou.service.DeptService;
import com.lanou.service.EmployeeService;
import com.lanou.service.JobService;
import com.lanou.service.SalaryService;
import com.lanou.util.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobService jobService;

    @Autowired
    private DeptService deptService;


    @RequestMapping("/list")
    public String list(HttpServletRequest request, PageModel pageModel,String content){
        PageHelper.startPage(pageModel.getPageIndex(),pageModel.getPageSize());
        List<Salary> list = salaryService.listAll(content);
        PageInfo pageInfo = new PageInfo(list);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("content",content);
        request.setAttribute("hre","salary/list");
        return "salary/list";
    }

    @RequestMapping("/toadd")
    public String add(){
        return "/salary/add";
    }
    @RequestMapping("/add")
    public String add1(HttpServletRequest request,Salary salary) {
        String name = request.getParameter("empname");
        salary.setEmp_id(employeeService.findByName(name).getId());
        salary.setDept_id(employeeService.findByName(name).getDept_id());
        salary.setJob_id(employeeService.findByName(name).getJob_id());
        salaryService.add(salary);
        return "redirect:/checkwork/list";
    }
    @RequestMapping("/toedit")
    public String toedit(Integer id,HttpServletRequest request){
        Salary salary = salaryService.findById(id);
        salary.setEmpname(employeeService.findById(salary.getEmp_id()).getName());
        List<Job> job_list = jobService.listAll(null);
        List<Dept> dept_list = deptService.listAll(null);
        request.setAttribute("job_list",job_list);
        request.setAttribute("dept_list",dept_list);
       request.setAttribute("salary",salary);
        return "salary/edit";
    }
    @RequestMapping("/edit")
    public String edit(HttpSession session, Salary salary){
        session.setAttribute("salary",salary);
        salaryService.update(salary);
        return "redirect:/salary/list";
    }
}
