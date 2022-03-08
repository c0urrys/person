package com.lanou.shiro;


import com.lanou.bean.User;

import com.lanou.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//自定义认证数据源
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("-------开始授权-------");
        //获取当前登录用户名
//        String loginname = (String) principalCollection.getPrimaryPrincipal();
//        //查询当前用户对应的角色、菜单等
//        //创建权限对象
//        User user = userService.findUserByName(loginname);
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        if(loginname!=null&&loginname.equals(user.getPassword())){
//            return null;
//        }else {
//
//        }


        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("--------开始认证------");
        String loginname = (String) authenticationToken.getPrincipal();
        System.out.println(loginname);
        //查询当前用户对应的角色、菜单等
        //创建权限对象
        User user = userService.findUserByName(loginname);
        System.out.println(user);
        if(loginname!=null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginname,
                    user.getPassword(), ByteSource.Util.bytes("123"), "myRealm");
            return info;
        }else {
            return null;
        }


//        String realPassword = "df49ec48e56522d11151fb9ecd683aef";
//        String realName = "admin";
    }
}
