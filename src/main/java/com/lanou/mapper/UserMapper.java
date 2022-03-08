package com.lanou.mapper;

import com.lanou.bean.User;

import java.util.List;

public interface UserMapper {
    User findUserByName(String loginname);

    User findUserById(String id);

    List<User> listAll(String name);

    int findCount();

    int addUser(User user);

    int update(User user);

    int delete(Integer id);
}
