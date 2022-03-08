package com.lanou.service;

import com.lanou.bean.User;
import com.lanou.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserServiceIml implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByName(String loginname) {
        User user = userMapper.findUserByName(loginname);
        return user;
    }

    @Override
    public User findUserById(String id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public List<User> listAll(String name) {
        List<User> userList = userMapper.listAll(name);
        return userList;
    }

    @Override
    public int findCount() {
        int cout= userMapper.findCount();

        return cout;
    }

    @Override
    public int addUser(User user) {
        int i = userMapper.addUser(user);
        return i;
    }

    @Override
    public int update(User user) {
        int i = userMapper.update(user);
        return i;
    }

    @Override
    public int delete(Integer id) {
        int i = userMapper.delete(id);
        return i;
    }
}
