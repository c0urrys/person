package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.*;

import com.lanou.service.*;
import com.lanou.util.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/checkwork")
public class CheckWorkController {

    @Autowired
    private CheckWorkService checkWorkService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobService jobService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private LeavetypeService leavetypeService;

    @Autowired
    private LeavestatusService leavestatusService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, CheckWork checkWork, String content, PageModel pageModel){
        PageHelper.startPage(pageModel.getPageIndex(),pageModel.getPageSize());
        List<CheckWork> list = checkWorkService.listAll(content);
        PageInfo pageInfo = new PageInfo(list);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("content",content);
        request.setAttribute("hre","checkwork/list");
        return "/checkwork/list";
    }

    @RequestMapping("/toadd")
    public String add(){
        return "/checkwork/add";
    }
    @RequestMapping("/add")
    public String add1(HttpServletRequest request,CheckWork checkWork) {
         String name = request.getParameter("empname");
         checkWork.setEmp_id(employeeService.findByName(name).getId());
         checkWork.setDept_id(employeeService.findByName(name).getDept_id());
         checkWork.setJob_id(employeeService.findByName(name).getJob_id());
         int i = checkWorkService.add(checkWork);
        return "redirect:/checkwork/list";
    }
    @RequestMapping("/toedit")
    public String toedit(Integer id,HttpServletRequest request){
        CheckWork checkWork = checkWorkService.findById(id);
        checkWork.setEmpname(employeeService.findById(checkWork.getEmp_id()).getName());
        List<Job> job_list = jobService.listAll(null);
        List<Dept> dept_list = deptService.listAll(null);
        request.setAttribute("job_list",job_list);
        request.setAttribute("dept_list",dept_list);
        request.setAttribute("checkwork",checkWork);
        return "checkwork/edit";
    }
    @RequestMapping("/edit")
    public String edit( HttpSession session,CheckWork checkWork){
        session.setAttribute("checkwork",checkWork);
        checkWorkService.update(checkWork);
        return "redirect:/checkwork/list";
    }
    @RequestMapping("/adminleavelist")
    public String adminleavelist(HttpServletRequest request,String content, PageModel pageModel){
        PageHelper.startPage(pageModel.getPageIndex(), pageModel.getPageSize());
        List<Leave> list = leaveService.listAll(content);
        PageInfo pageInfo = new PageInfo(list);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("content",content);
        request.setAttribute("hre","checkwork/adminleavelist");
        return "checkwork/adminleavelist";
    }
    @RequestMapping("/toadminleaveedit")
    public String toadminleaveedit(Integer id,HttpServletRequest request){
        Leave leave = leaveService.findById(id);
        List<Leavestatus> leavestatusList = leavestatusService.listAll();
        List<Leavetype> leavetypeList = leavetypeService.listAll();
        request.setAttribute("leave",leave);
        request.setAttribute("leavetype_list",leavetypeList);
        request.setAttribute("leavestatus_list",leavestatusList);
        return "checkwork/adminleaveedit";
    }

    @RequestMapping("/adminleaveedit")
    public String adminleaveedit(Leave leave,HttpSession session){
        leaveService.update(leave);
        session.setAttribute("leave",leave);
        return "redirect:/checkwork/adminleavelist";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        leaveService.delete(id);
        return "redirect:/checkwork/adminleavelist";
    }
}
