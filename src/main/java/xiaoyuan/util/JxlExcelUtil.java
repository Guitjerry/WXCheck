package com.xiaoyuan.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

;

/**
 * Created by jerry on 2017/3/29.
 */
public class JxlExcelUtil {
    private int getRightRows(Sheet sheet) {
        int rsCols = sheet.getColumns(); //列数
        int rsRows = sheet.getRows(); //行数
        int nullCellNum;
        int afterRows = rsRows;
        for (int i = 1;
             i < rsRows; i++) { //统计行中为空的单元格数
            nullCellNum = 0;
            for (int j
                 = 0; j < rsCols; j++) {
                String val = sheet.getCell(j, i).getContents();
                val = StringUtils.trimToEmpty(val);
                if (StringUtils.isBlank(val))
                    nullCellNum++;
            }
            if (nullCellNum >= rsCols) { //如果nullCellNum大于或等于总的列数
                afterRows--;          //行数减一
            }
        }
        return afterRows;
    }

    /**
     * 描述：获取IO流中的数据，组装成List<List<Object>>对象
     * @param in,fileName
     * @param filepath
     * @param excelConfig
     * @return
     * @throws Exception
     */
    public  List<List<Object>> getBankListByJXLExcel(InputStream in, String fileName, Object target, String filepath, ExcelConfig excelConfig) throws Exception{


        List<Element> elecloumns = null;
        if(excelConfig!=null){
            elecloumns =  excelConfig.getElecloumns();
        }
        List<List<Object>> list = new ArrayList<List<Object>>();
        // 2、声明工作簿对象
        Workbook rwb = Workbook.getWorkbook(in);
        // 3、获得工作簿的个数,对应于一个excel中的工作表个数
        int sheets = rwb.getNumberOfSheets();
        Sheet sheet = null;
        for(int i=0;i<sheets;i++){
            sheet = rwb.getSheet(i);
            int  rows=getRightRows(sheet);//获取工作表中的总行数
            int columns = sheet.getColumns();//获取工作表中的总列数
            //去除空的记录


            Object okj = null;
            for (int j = 1; j < rows; j++) {
                List<Object> li = new ArrayList<Object>();
                int nullCellNum = 0;
                if(target!=null){

                    for (int m = 0; m < columns; m++) {
                        String cloumnname =  elecloumns.get(m).getTextTrim().toLowerCase();
                        Cell oCell= sheet.getCell(m,j);//第j行的第m列

                        String val = StringUtils.trimToEmpty(oCell.getContents());
                        if (StringUtils.isBlank(val)) nullCellNum++;
                    if(!StringUtils.isEmpty(oCell.getContents())){
                        ReflectionUtils.setFieldValue(target,cloumnname,oCell.getContents().trim());
                    }

                        if (nullCellNum >= columns) { //如果nullCellNum大于或等于总的列数

                        }

                    }

                    okj = target.getClass().newInstance();
                    BeanUtils.copyProperties(target,okj);
                    li.add(okj);
                    list.add(li);
                }else{
                    for (int m = 0; m < columns; m++) {
                        Cell oCell= sheet.getCell(m,j);//第j行的第m列
                        li.add(String.valueOf(oCell.getContents().trim()));
                    }
                    list.add(li);
                }

            }
        }
        return list;
    }

    /**
     * 封装excel配置文件
     * @return
     */
    public ExcelConfig combineExcelConfig(String filePath, String tablename){
        ExcelConfig excelConfig = null;
        if(!StringUtils.isEmpty(filePath)){
            try {
                File configfile = new File(filePath);
                SAXReader reader = new SAXReader();
                Document document = reader.read(configfile);
                Element root = document.getRootElement();
                Element choosetable = document.getRootElement();
                List<Element> tableelement = root.elements("table");
                for(Element tableele:tableelement){
                    if(tableele.attributeValue("name").equals(tablename)){
                        choosetable = tableele;
                    }
                }
                List<Element> elecloumns = choosetable.elements("column");
                List<Element> validatecloumns = choosetable.elements("validate");
                List<Element> updatecloumns = choosetable.elements("update");
                List<Element> selecterrorcloumns = choosetable.elements("selecterror");
                List<Element> selectsuccesscloumns = choosetable.elements("selectsuccess");
                 excelConfig = new ExcelConfig(elecloumns,validatecloumns,updatecloumns,selecterrorcloumns,selectsuccesscloumns);
                return excelConfig;
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            excelConfig =null;
        }
        return excelConfig;
    }
}
