package com.lanou.web;

import com.lanou.bean.User;
import com.lanou.service.UserService;
import com.lanou.util.MyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j

public class RegistCode {

    @Autowired
    private UserService userService;

    @RequestMapping("/registCode")
    public String toregistCode(){

        return "regist";
    }

    @RequestMapping("/toLogin")
    public String register(HttpServletRequest request){
        String name = request.getParameter("loginname");
        System.out.println(name);
        return "loginForm";
    }

    @RequestMapping("/register")
    public String register1(HttpServletRequest request){
        User user = new User();
        MyUtil myUtil = new MyUtil();
        user.setLoginname(request.getParameter("loginname"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(myUtil.md5(request.getParameter("password")));
        user.setEmail(request.getParameter("email"));
        user.setEmp_id(null);
        userService.addUser(user);
        return "loginForm";
    }

    @RequestMapping("/checkMessage")
    @ResponseBody
    public String register2(){
        return "注册成功";
    }
}
