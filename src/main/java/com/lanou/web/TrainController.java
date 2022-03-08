package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.*;
import com.lanou.mapper.TrainMapper;
import com.lanou.service.*;
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
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private JobService jobService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private CompletionService completionService;

    @RequestMapping("/totrain")
    public String train(){

        return "train/train";
    }

    @RequestMapping("/admintrainlist")
    public String admintrainlist(HttpServletRequest request, PageModel pageModel, String content){
        PageHelper.startPage(pageModel.getPageIndex(),pageModel.getPageSize());
        List<Train> list = trainService.listAll(content);
        PageInfo pageInfo = new PageInfo(list);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("content",content);
        request.setAttribute("hre","train/admintrainlist");
        return "train/admintrainlist";
    }

    @RequestMapping("/traintoadd")
    public String traintoadd(HttpServletRequest request){
        List<Completion> list = completionService.listAll();
        request.setAttribute("completion_list",list);
        return "train/add";
    }

    @RequestMapping("/list")
    public String trainlist(){

        return "train/trainlist";
    }


    @RequestMapping("/toadd")
    public String add(){
        return "/train/add";
    }
    @RequestMapping("/add")
    public String add1(HttpServletRequest request,Train train) {
        String name = request.getParameter("empname");
        train.setEmp_id(employeeService.findByName(name).getId());
        train.setDept_id(employeeService.findByName(name).getDept_id());
        train.setJob_id(employeeService.findByName(name).getJob_id());
        trainService.insert(train);
        return "redirect:/train/admintrainlist";
    }
    @RequestMapping("/toedit")
    public String toedit(Integer id,HttpServletRequest request){
        Train train = trainService.findById(id);
        train.setEmpname(employeeService.findById(train.getEmp_id()).getName());
        List<Job> job_list = jobService.listAll(null);
        List<Dept> dept_list = deptService.listAll(null);
        List<Completion> list1 = completionService.listAll();
        request.setAttribute("job_list",job_list);
        request.setAttribute("dept_list",dept_list);
        request.setAttribute("train",train);
        request.setAttribute("completion_list",list1);
        return "train/edit";
    }
    @RequestMapping("/edit")
    public String edit(HttpSession session, Train train){
        session.setAttribute("train",train);
        trainService.update(train);
        return "redirect:/train/admintrainlist";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        trainService.delete(id);
        return "redirect:/train/admintrainlist";
    }


}
