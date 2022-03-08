package com.lanou.mapper;

import com.lanou.bean.Emp;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface EmployeeMapper {
    List<Emp> listAll(String name);

    Emp findById(Integer id);

    Emp findByName(String name);

    int update(Emp emp);

    int delete(Integer id);

    int add(Emp emp);

    int addList(List<Emp> empList);

    int importExcel(MultipartFile file);


}
