<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>创新创业型小微企业的人力资源管理平台</title>
<meta content="" name="description" />
<meta content="" name="author" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    
    <meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/logo.ico" type="image/x-icon" />
<link href="${pageContext.request.contextPath}/js/metronic/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/js/metronic/css/base.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/js/metronic/css/login.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/metronic/css/jquery.slider.css" type="text/css" />


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/xadmin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ajax_js/register_check.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.slider.js"></script>
<script type="text/javascript">
setTimeout(function(){document.getElementById("regist_message").style.display="none";},10000);
</script>

<style type="text/css">
body{
       overflow:scroll;
       overflow-x:hidden;
    }
</style>

<script>
    $(function (){
        $("#toLoginForm").submit(function(){
            var loginname = $("#loginname");
            var username = $("#username");
            var password = $("#password");
            var repassword = $("#repassword");
            var email= $("#email");//邮箱
            var msg = "";
            if (!/^[A-Za-z0-9]{5,15}$/.test($.trim(loginname.val()))){
                msg = "登录名格式不正确！";
                loginname.focus();
            }
            else if (!/^[\u4E00-\u9FA5]{2,4}$/.test($.trim(username.val()))){
                msg = "用户名格式不正确！！！";
                username.focus();
            }
            else if (!/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test($.trim(email.val()))){
                msg = "邮箱格式不正确！！！";
                email.focus();
            }
            else if (!/^[A-Za-z0-9]{5,15}$/.test($.trim(password.val()))){
                msg = "密码格式不正确！！！";
                password.focus();
            }
            else if ($.trim(password.val())!=$.trim(repassword.val())){
                msg = "两次密码输入不相同，请重新输入！";
                repassword.focus();
            }
            if (msg != ""){
                alert(msg);
                return false;
            }else{
                return true;
                $("#toLoginForm").submit();

            }
        });
    });
</script>
</head>
<body oncontextmenu="self.event.returnValue=false" onselectstart="return false" >
<div style="width: 1600px;height:48px; background-color:RGB(43,48,59) ">
      <ul style="margin-left: 40px;padding-top:6px">
        <li style="display: inline-block;"><h1><a href="loginForm.jsp" style="color:white;font-size:20px;">晨辉搜房网系统</a></h1></li>
        <li style="display: inline-block; margin-left: 120px;"><a  style="font-size:14px;color:rgb(130,130,130); " >用户注册</a></li>
        <li style="display: inline-block; margin-left: 60px;"><a href="loginForm.jsp" style="font-size:14px;color:rgb(130,130,130); ">首页</a></li>
        <li style="display: inline-block; margin-left: 80px;"><a href="javascript:alert('本系统只提供管理员和公司管理人员登录系统！！！如若注册此系统，请联系部门负责人下发注册码 ！！！');"	  style="font-size:14px;color:rgb(130,130,130); ">帮助与文档</a></li>
        <li style="display: inline-block; margin-left: 64px;"><p  style="font-size:14px;color:rgb(130,130,130);">客服电话：4008864211</p></li>
      </ul>    
    </div> 
    <div id="main" style="width:1600px;height:693px;float:left;">
          
      <div class="container" style="background-color:rgb(73,74,95);width: 1600px;height:693px;float:left;"> 
        <!-- <div  style="background-color:green;width: 1360px;height:610px; float:left;"> -->
       <!-- 幻灯片 -->
       
       <div class="testSlider" style="margin-left:-15px;"></div>
         
		 <div id="register"  class="register" style="height:460px;margin-top:100px;margin-left:325px;opacity:0.9;">
            <div class="title">
                <span style="color: rgb(32,35,64);">用户注册</span>
                 <div style="height: 10px;margin-top: 15px;">
                     <input id="register_check_message" disabled="disabled" size="50" value=""style= "background-color:transparent;border:0;color: red"/>
                 </div>
            </div>  
            <form  method="post" action="${pageContext.request.contextPath}/register" name="check-form" id="toLoginForm">
                
                <div class="default" style="margin-top:20px;">
                    <input 	data-form="uname" type="text" placeholder="请输入登录名  登录名不小于5个字母"  id="loginname" name="loginname" value="${loginname}" onchange="check_register_loginname()"/>
                </div>
                <div style="height: 10px;margin-top: -10px;">
                     <input id="loginname_message" disabled="disabled"  value=""style= "background-color:transparent;border:0;color: red"/>          
                </div>
                
                
                 <div class="default">
                    <input 	data-form="uname" type="text" placeholder="请输入用户名  用户名是你的姓名"  id="username" name="username" value="${username}" onchange="check_register_username()"/>
                </div>
                 <div style="height: 10px;margin-top: -10px;">
                     <input id="username_message" disabled="disabled"  value=""style= "background-color:transparent;border:0;color: red"/>          
                </div>
                
                
                <div class="default">
                    <input 	data-form="uname" type="text" placeholder="请输入邮箱  "  id="email" name="email" value="${email}" onchange="check_register_email()"/>
                </div>
                 <div style="height: 10px;margin-top: -10px;">
                     <input id="email_message" disabled="disabled"  value=""style= "background-color:transparent;border:0;color: red"/>          
                </div>
                
                <div class="default">
                    <input id="password" name="password"
									value="${password}" data-form="upwd" type="password" placeholder="请输入密码   密码 6-12位数字和字母组合" onchange="check_register_password()"/>
                </div>
                <div style="height: 10px;margin-top: -10px;">
                     <input id="password_message" disabled="disabled"  value=""style= "background-color:transparent;border:0;color: red"/>          
                </div>
                
                <div class="default">
                    <input id="repassword" name="repassword"
									value="${repassword}" data-form="upwd" type="password" placeholder="请确认密码 " onchange="check_register_repassword()"/>
                </div>
                 <div style="height: 10px;margin-top: -10px;">
                     <input id="repassword_message" disabled="disabled"  value=""style= "background-color:transparent;border:0;color: red"/>          
                </div>
             
                <div class="submit" style="margin-top: 16px;">
                    <input type="submit" value="注册" class="s_hover" lay-filter="add" lay-submit=""/>
                    <input id="login-submit-btn2" class="s_hover" type="button" value="去登录" onclick="toLogin()"/>
                </div>
            </form> 
           
            <div id="regist_message" style="color: red;margin-left:50px;margin-top:-30px;">${message}</div>
        </div>
       </div>
      </div>
       <!-- 底部开始 -->
     <div style="width: 1600px;height:48px; background-color:RGB(43,48,59) ;margin-top:693px;">
        <div align="center" style="padding-top:15px;color:RGB(153,153,153);">Copyright ©2019 </div>
    </div>
   		 <!-- 底部结束 -->
    
     <script>
window.onload = function(){
	var currentIndex = 0;
	$('.testSlider').slider({
		originType:'tuoyuan'
	});
}
</script>
    
</body>
</html>