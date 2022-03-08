package com.lanou.mapper;

import com.lanou.bean.Document;

import java.util.List;

public interface DocumentMapper {
    List<Document> listAll(String name);

    Document findById(Integer id);

    int add(Document document);

    int update(Document document);

    int delete(Integer id);
}
