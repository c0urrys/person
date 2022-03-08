package com.lanou.web.dormitory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.lanou.dao.DormitoryDaoImpl;
import com.lanou.dao.MenuDaoImpl;
import com.lanou.dao.StudentDaoImpl;
import com.lanou.util.ResultUtil;
import com.laou.pojo.Admin;
import com.laou.pojo.Dormitory;
import com.laou.pojo.Menu;
@WebServlet("/dormitory/singleUpload")
@MultipartConfig
public class SingleUpload extends HttpServlet{
	 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		Part part = req.getPart("file");
		String filename = part.getSubmittedFileName();
		//保存文件
		FileOutputStream out = new FileOutputStream(new File("F:\\eclipse-workspace-ss\\dormitory2\\WebContent\\file\\"+filename));
		IOUtils.copy(part.getInputStream(), out);
		
		//map -- code=0 image=图片路径
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("image", "/file/"+filename);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().append(JSON.toJSONString(map));
	}
	
	
}
