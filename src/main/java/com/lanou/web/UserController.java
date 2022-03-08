package com.lanou.web;

import com.lanou.bean.User;
import com.lanou.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.SessionScope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String longin(HttpServletRequest request, HttpServletResponse response){
        //获取当前主题
        Subject subject = SecurityUtils.getSubject();
        String loginname = request.getParameter("loginname");
        String password = request.getParameter("password");
        //封装用户密码token
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(loginname);
        token.setPassword(password.toCharArray());
        User user_session = userService.findUserByName(loginname);

        request.getSession().setAttribute("user_session",user_session);
        //调用shiro的认证方法
        /*
         * 调用shiro的认证方法
         * 如果方法抛出异常，则认证失败
         * 如果方法没有异常，则认证成功
         * */
        try{
            //记住我
            token.setRememberMe(true);
            subject.login(token);
        }catch (Exception e){
            log.error("认证失败");
            return "/loginForm";
        }
        return "/index";
    }
    @RequestMapping("/exit")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "loginForm";
    }


    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request, HttpServletResponse response){

        return "welcome";
    }

}
