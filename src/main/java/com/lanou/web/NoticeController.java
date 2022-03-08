package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Notice;
import com.lanou.service.NoticeService;
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
@RequestMapping("/notice")
public class NoticeController{

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, PageModel pageModel,String content){
        PageHelper.startPage(pageModel.getPageIndex(), pageModel.getPageSize());
        List<Notice> list = noticeService.listAll(content);
        PageInfo pageInfo = new PageInfo(list);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("content",content);
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("hre","notice/list");
        return "notice/list";
    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "notice/add";
    }

    @RequestMapping("/add")
    public String add(Notice notice){
        noticeService.add(notice);
        return "redirect:/notice/list";
    }

    @RequestMapping("/toedit")
    public String toedit(Integer id,HttpServletRequest request){
         Notice notice = noticeService.findById(id);
        request.setAttribute("notice",notice);
        return "/notice/edit";
    }

    @RequestMapping("/edit")
    public String edit(Notice notice, HttpSession session,Integer user_id){
        notice.setUser_id(user_id);
        noticeService.update(notice);
        session.setAttribute("notice",notice);
        return "redirect:/notice/list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        noticeService.delete(id);
        return "redirect:/notice/list";
    }
}
