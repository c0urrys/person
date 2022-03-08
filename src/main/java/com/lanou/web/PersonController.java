package com.lanou.web;

import com.github.pagehelper.PageHelper;
import com.lanou.bean.Job;
import com.lanou.bean.Status;
import com.lanou.bean.User;
import com.lanou.service.JobService;
import com.lanou.service.StatusService;
import com.lanou.service.UserService;
import com.lanou.util.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/user")
public class PersonController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @Autowired
    private StatusService statusService;

    @RequestMapping("/list")
    public  String getList(HttpServletRequest request,String name,PageModel pageModel){

        PageHelper.startPage(pageModel.getPageIndex(), pageModel.getPageSize());
        List<User> list = userService.listAll(name);
        pageModel.setRecordCount(userService.findCount());
        request.setAttribute("list",list);
        request.setAttribute("count",userService.findCount());
        request.setAttribute("pageModel1",pageModel);
        request.setAttribute("name",name);
        request.setAttribute("hre","user/list");

        return "user/list";
    }
    @RequestMapping("/toadd")
    public String addUser(HttpServletRequest request){
        List<Job> emp_list = jobService.listAll(null);
        request.setAttribute("emp_list",emp_list);
        return "/user/add";
    }
    @RequestMapping("/add")
    public String addUser1(HttpServletRequest request){
        String loginname = request.getParameter("loginname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String emp_id =  request.getParameter("emp_id");
        User user = new User();
        user.setLoginname(loginname);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setEmp_id(Integer.parseInt(emp_id));
        int i = userService.addUser(user);
        return "redirect:/user/list";
    }
//    @RequestMapping("/list")
//    public String userList(){
//        return "/user/topedit";
//    }
    @RequestMapping("/toedit")
    public String editUser(HttpServletRequest request,String id){
        List<Job> emp_list = jobService.listAll(null);
        User user = userService.findUserById(id);
        List<Status> statusList = statusService.listAll();
        request.setAttribute("emp_list",emp_list);
        request.setAttribute("user",user);
        request.setAttribute("status_list",statusList);
        return "/user/edit";
    }
    @RequestMapping("/checkedit")
    public String editUser1(User user,HttpSession session,Integer status_id){

            user.setStatus_id(status_id);
            userService.update(user);
            session.setAttribute("user",user);

            return "redirect:/user/list";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        int i = userService.delete(id);
        return "redirect:/user/list";
    }


}
