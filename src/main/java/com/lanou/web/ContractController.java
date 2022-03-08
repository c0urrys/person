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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobService jobService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private ConfidentialitycontractService confidentialitycontractService;


    @RequestMapping("/list")
    public String list(HttpServletRequest request, PageModel pageModel, String content){
        PageHelper.startPage(pageModel.getPageIndex(),pageModel.getPageSize());
        List<Contract> list = contractService.listAll(content);
        PageInfo pageInfo = new PageInfo(list);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("content",content);
        request.setAttribute("hre","contract/list");
        return "contract/list";
    }

    @RequestMapping("/toadd")
    public String add(){
        return "/contract/add";
    }
    @RequestMapping("/add")
    public String add1(HttpServletRequest request,Contract contract) {
        String name = request.getParameter("empname");
        contract.setEmp_id(employeeService.findByName(name).getId());
        contract.setDept_id(employeeService.findByName(name).getDept_id());
        contract.setJob_id(employeeService.findByName(name).getJob_id());
        contractService.add(contract);
        return "redirect:/contract/list";
    }
    @RequestMapping("/toedit")
    public String toedit(Integer id,HttpServletRequest request){
        Contract contract = contractService.findById(id);
        contract.setEmpname(employeeService.findById(contract.getEmp_id()).getName());
        List<Job> job_list = jobService.listAll(null);
        List<Dept> dept_list = deptService.listAll(null);
        List<Confidentialitycontract> list1 = confidentialitycontractService.listAll();
        request.setAttribute("job_list",job_list);
        request.setAttribute("dept_list",dept_list);
        request.setAttribute("contract",contract);
        request.setAttribute("status_list",list1);
        return "contract/edit";
    }
    @RequestMapping("/edit")
    public String edit(HttpSession session, Contract contract){
        session.setAttribute("contract",contract);
        contractService.update(contract);
        return "redirect:/contract/list";
    }
}
