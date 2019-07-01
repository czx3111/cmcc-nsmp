package com.ultrapower.web;

import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class POITest {

    @Test
    public void test1() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("表一");
        XSSFRow row = sheet.createRow(1);
        XSSFCell cell = row.createCell(1);
        cell.setCellValue("aaaaaaaa");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop/1.xlsx");
        workbook.write(fileOutputStream);
    }

    @Test
    public void test2() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop/1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(1);
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);
    }

    @Test
    public void test3() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop/1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        int rows = sheetAt.getPhysicalNumberOfRows();
        for (int i =0;i<rows;i++){
            XSSFRow row = sheetAt.getRow(i);
            int cells = row.getPhysicalNumberOfCells();
            for (int j=0;j<cells;j++){
                XSSFCell cell = row.getCell(j);
            }
        }
    }
}
