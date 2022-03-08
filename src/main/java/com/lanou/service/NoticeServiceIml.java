package com.lanou.service;

import com.lanou.bean.Notice;
import com.lanou.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class NoticeServiceIml implements NoticeService{
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> listAll(String name) {
        List<Notice> list = noticeMapper.listAll(name);
        return list;
    }

    @Override
    public Notice findById(Integer id) {
         Notice notice = noticeMapper.findById(id);
        return notice;
    }

    @Override
    public int add(Notice notice) {
        int i = noticeMapper.add(notice);
        return i;
    }

    @Override
    public int update(Notice notice) {
        int i = noticeMapper.update(notice);
        return i;
    }

    @Override
    public int delete(Integer id) {
        int i = noticeMapper.delete(id);
        return i;
    }
}
