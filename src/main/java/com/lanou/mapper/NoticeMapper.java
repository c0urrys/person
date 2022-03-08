package com.lanou.mapper;

import com.lanou.bean.Notice;

import java.util.List;

public interface NoticeMapper {
    List<Notice> listAll(String name);

    Notice findById(Integer id);

    int add(Notice notice);

    int update(Notice notice);

    int delete(Integer id);
}
