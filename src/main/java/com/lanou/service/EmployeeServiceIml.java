package com.lanou.service;

import com.lanou.bean.Emp;
import com.lanou.mapper.EmployeeMapper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
public class EmployeeServiceIml implements EmployeeService{

    private static final String XLS = "xls";

    private static final String XLSK = "xlsx";

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Emp> listAll(String name) {
        List<Emp> list = employeeMapper.listAll(name);
        return list;
    }

    @Override
    public Emp findById(Integer id) {
        Emp emp = employeeMapper.findById(id);
        return emp;
    }

    @Override
    public Emp findByName(String name) {
        Emp emp = employeeMapper.findByName(name);
        return emp;
    }

    @Override
    public int update(Emp emp) {
        int i = employeeMapper.update(emp);
        return i;
    }

    @Override
    public int delete(Integer id) {
        int i = employeeMapper.delete(id);
        return i;
    }

    @Override
    public int add(Emp emp) {
        int i = employeeMapper.add(emp);
        return i;
    }

    @Override
    public int addList(List<Emp> empList) {
        int i = employeeMapper.addList(empList);
        return i;
    }

    @Override
    @SuppressWarnings("resource")
    public int importExcel(MultipartFile file) {
        List<Emp> list = new ArrayList();
//        Map<String, Object> rsultMap = new HashMap<String, Object>();


        Workbook workbook = null;
        String fileName = file.getOriginalFilename();
        if(fileName.endsWith(XLS)) {
            //2003
            try {
                workbook = new HSSFWorkbook(file.getInputStream());
            } catch (Exception e) {
                e.printStackTrace( );
            }

        }else if(fileName.endsWith(XLSK)) {
            try {
                //2007
                workbook = new XSSFWorkbook(file.getInputStream());
            } catch (Exception e) {
                e.printStackTrace( );
            }
        }
        Sheet sheet = workbook.getSheet("Sheet1");
        int rows = sheet.getLastRowNum();//指定行数。一共多少+

        for (int i = 1; i < 8; i++){
            //读取左上端单元格
            Row row = sheet.getRow(i);
            //行不为空
            if(row != null) {
                //读取cell
                Emp emp = new Emp();

                emp.setDept_id(Integer.parseInt(getCellValue(row.getCell(1))));
                emp.setJob_id(Integer.parseInt(getCellValue(row.getCell(2))));
                emp.setName(getCellValue(row.getCell(3)));
                emp.setCard_id(getCellValue(row.getCell(4)));
                emp.setAddress(getCellValue(row.getCell(5)));
                emp.setPhone(getCellValue(row.getCell(6)));
                emp.setSex_id(Integer.parseInt(getCellValue(row.getCell(7))));
                emp.setEducation_id(Integer.parseInt(getCellValue(row.getCell(8))));
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String time = sdf.format(new Date());


                list.add(emp);//把实数据放入集合里
            }
        }
        try {
            employeeMapper.addList(list);//批量添加 (执行sql语句批量增加)

        } catch (Exception e) {

        }

        return 0;
    }

    private String getCellValue(Cell cell) {
        String value = "";
        if(cell != null) {
            //以下是判断数据的类型
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC://数字
                    value = cell.getNumericCellValue() + "";
                    if(HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        if(date != null) {
                            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        }else {
                            value = "";
                        }
                    }else {
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: //字符串
                    value = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN: //boolean
                    value = cell.getBooleanCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_FORMULA: //公式
                    value = cell.getCellFormula() + "";
                    break;
                case HSSFCell.CELL_TYPE_BLANK: //空值
                    value = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: //故障
                    value = "非法字符";
                    break;
                default:
                    value = "未知类型";
                    break;
            }
        }
        return value.trim();
    }
}
