package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Dept;
import com.lanou.bean.Job;
import com.lanou.service.JobService;
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
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @RequestMapping("/list")
    public String list(HttpServletRequest request, String content, PageModel pageModel){
        PageHelper.startPage(pageModel.getPageIndex(), pageModel.getPageSize());
        List<Job> list = jobService.listAll(content);
        PageInfo pageInfo = new PageInfo(list);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("content",content);
        request.setAttribute("hre","job/list");
        return "job/list";
    }

    @RequestMapping("/toadd")
    public String add(){
        return "/job/add";
    }

    @RequestMapping("/add")
    public String add1(Job job){
        jobService.add(job);
        return "redirect:/job/list";
    }
    @RequestMapping("/toedit")
    public String toedit(HttpServletRequest request,Integer id){
        Job job  = jobService.findById(id);
        request.setAttribute("job",job);
        return "job/edit";
    }
    @RequestMapping("/edit")
    public String edit(Integer id, Job job, HttpSession session){
        job.setId(id);
        jobService.update(job);
        session.setAttribute("job",job);
        return "redirect:/job/list";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        int i = jobService.delete(id);
        return "redirect:/job/list";
    }


}
