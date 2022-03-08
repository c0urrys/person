package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Dept;
import com.lanou.service.DeptService;
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
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping("/list")
    public String list(HttpServletRequest request, String content, PageModel pageModel){
        PageHelper.startPage(pageModel.getPageIndex(), pageModel.getPageSize());
        List<Dept> list = deptService.listAll(content);
        PageInfo pageInfo = new PageInfo(list);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("content",content);
        request.setAttribute("hre","dept/list");
        return "dept/list";
    }
    @RequestMapping("/toadd")
    public String add(){
        return "/dept/add";
    }
    @RequestMapping("/add")
    public String add1(Dept dept){
        deptService.insert(dept);
        return "redirect:/dept/list";
    }
    @RequestMapping("/toedit")
    public String toedit(Integer id,HttpServletRequest request){
         Dept dept = deptService.findById(id);
        request.setAttribute("dept",dept);
        return "dept/edit";
    }
    @RequestMapping("/edit")
    public String edit(Dept dept,HttpSession session ,Integer id){
        dept.setId(id);
        session.setAttribute("dept",dept);
        deptService.update(dept);
        return "redirect:/dept/list";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        int i = deptService.delete(id);
        return "redirect:/dept/list";
    }
}
