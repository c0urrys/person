package com.lanou.service;

import com.lanou.bean.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> listAll(String name);

    Notice findById(Integer id);

    int add(Notice notice);

    int update(Notice notice);

    int delete(Integer id);
}
