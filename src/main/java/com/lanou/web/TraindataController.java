package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Document;
import com.lanou.bean.Train;
import com.lanou.bean.Traindata;
import com.lanou.service.TraindataService;
import com.lanou.util.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.taglibs.standard.lang.jstl.StringLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/traindata")
public class TraindataController {
    @Autowired
    private TraindataService traindataService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, String content, PageModel pageModel){
        PageHelper.startPage(pageModel.getPageIndex(),pageModel.getPageSize());
        List<Traindata> list = traindataService.listAll(content);
        PageInfo pageInfo = new PageInfo(list);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("content",content);
        request.setAttribute("hre","traindata/list");
        return "traindata/list";
    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "/traindata/add";
    }
    @RequestMapping("/add")
    public String add(Traindata traindata, MultipartFile file) throws IOException {
        file.transferTo(new File("D:\\桌面\\idealianxi\\personnel\\web\\upload\\"+file.getOriginalFilename()));
        traindata.setFilename(file.getOriginalFilename());
        traindataService.insert(traindata);
        return "redirect:/traindata/list";
    }
    @RequestMapping("/toedit")
    public String toedit(Integer id,HttpServletRequest request){
        Traindata traindata = traindataService.findById(id);
        request.setAttribute("data",traindata);
        return "traindata/edit";
    }
    @RequestMapping("/edit")
    public String edit(Traindata traindata, HttpSession session , Integer id, MultipartFile file) throws IOException {
        traindata.setId(id);
        file.transferTo(new File("D:\\桌面\\idealianxi\\personnel\\web\\upload\\"+file.getOriginalFilename()));
        traindata.setFilename(file.getOriginalFilename());
        session.setAttribute("data",traindata);
        int i = traindataService.update(traindata);
//        if(i != 0){
//            File file1 = new File("D:\\桌面\\idealianxi\\personnel\\web\\WEB-INF\\files\\");
//            file1.delete();
//        }
        return "redirect:/traindata/list";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        int i = traindataService.delete(id);
        String name = traindataService.findById(id).getFilename();
        File file = new File("D:\\桌面\\idealianxi\\personnel\\web\\upload\\"+name);
        file.delete();
        return "redirect:/traindata/list";
    }

    @RequestMapping("/downLoad")
    public void  downLoad(String filename, HttpServletResponse response) throws IOException {
        String name = filename;
        File file = new File("D:\\桌面\\idealianxi\\personnel\\web\\upload\\"+name);
        //设置响应头
        response.setHeader("Content-Disposition", "attachment; filename="+name);
        FileUtils.copyFile(file, response.getOutputStream());
    }

    @RequestMapping("/play")
    public String play(HttpServletRequest request,String filename){
        request.setAttribute("filename",filename);
        return "traindata/play";
    }
}
