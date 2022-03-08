package com.lanou.service;

import com.lanou.bean.Document;
import com.lanou.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class DocumentServiceIml implements DocumentService{
    @Autowired
    private DocumentMapper documentMapper;
    @Override
    public List<Document> listAll(String name) {
        List<Document> list = documentMapper.listAll(name);
        return list;
    }

    @Override
    public Document findById(Integer id) {
        Document document = documentMapper.findById(id);
        return document;
    }

    @Override
    public int add(Document document) {
        int i = documentMapper.add(document);
        return i;
    }

    @Override
    public int update(Document document) {
        int i = documentMapper.update(document);
        return i;
    }

    @Override
    public int delete(Integer id) {
        int i = documentMapper.delete(id);
        return 0;
    }
}
