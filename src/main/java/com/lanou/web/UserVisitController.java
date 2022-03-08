package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Uservisit;
import com.lanou.service.UserVisitService;
import com.lanou.util.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/uservisit")
public class UserVisitController {
    @Autowired
    private UserVisitService userVisitService;

    @RequestMapping("/list")
    public String listVisit(HttpServletRequest request, String content, PageModel pageModel){
        PageHelper.startPage(pageModel.getPageIndex(),pageModel.getPageSize());
        List<Uservisit> uservisitList = userVisitService.listAll(content);
        PageInfo pageInfo = new PageInfo(uservisitList);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("list",uservisitList);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("hre","uservisit/list");
        request.setAttribute("content",content);
        return "uservisit/list";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        int i = userVisitService.delete(id);
        System.out.println(id);
        return "redirect:/uservisit/list";
    }

}
