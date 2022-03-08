package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Dept;
import com.lanou.bean.Document;
import com.lanou.service.DocumentService;
import com.lanou.service.UserService;
import com.lanou.util.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
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
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;


    @RequestMapping("/list")
    public String list(HttpServletRequest request, PageModel pageModel,String content){
        PageHelper.startPage(pageModel.getPageIndex(),pageModel.getPageSize());
        List<Document> list = documentService.listAll(content);
        PageInfo pageInfo = new PageInfo(list);
        pageModel.setRecordCount((int)pageInfo.getTotal());
        request.setAttribute("list",list);
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("count",pageInfo.getTotal());
        request.setAttribute("content",content);
        request.setAttribute("hre","document/list");
        return "document/list";
    }

    @RequestMapping("/toadd")
    public String add(){
        return "/document/add";
    }
    @RequestMapping("/add")
    public String add1(Document document, MultipartFile file) throws IOException {
        file.transferTo(new File("D:\\桌面\\idealianxi\\personnel\\web\\WEB-INF\\files\\"+file.getOriginalFilename()));
        document.setFilename(file.getOriginalFilename());
        documentService.add(document);
        return "redirect:/document/list";
    }
    @RequestMapping("/toedit")
    public String toedit(Integer id,HttpServletRequest request){
        Document document = documentService.findById(id);
        request.setAttribute("document",document);
        return "document/edit";
    }
    @RequestMapping("/edit")
    public String edit(Document document, HttpSession session , Integer id,MultipartFile file) throws IOException {
        document.setId(id);
        file.transferTo(new File("D:\\桌面\\idealianxi\\personnel\\web\\WEB-INF\\files\\"+file.getOriginalFilename()));
        document.setFilename(file.getOriginalFilename());
        session.setAttribute("document",document);
        int i = documentService.update(document);
//        if(i != 0){
//            File file1 = new File("D:\\桌面\\idealianxi\\personnel\\web\\WEB-INF\\files\\");
//            file1.delete();
//        }
        return "redirect:/document/list";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        int i = documentService.delete(id);

        String name = documentService.findById(id).getFilename();
        File file = new File("D:\\桌面\\idealianxi\\personnel\\web\\WEB-INF\\files\\"+name);
        return "redirect:/document/list";
    }

    @RequestMapping("/downLoad")
    public void  downLoad(Integer id, HttpServletResponse response) throws IOException {

        String name = documentService.findById(id).getFilename();

        File file = new File("D:\\桌面\\idealianxi\\personnel\\web\\WEB-INF\\files\\"+name);
        //设置响应头
        response.setHeader("Content-Disposition", "attachment; filename="+name);

        FileUtils.copyFile(file, response.getOutputStream());
        
    }
}
