package com.ultrapower.web;

import com.ultrapower.dao.AmAssetMapper;
import com.ultrapower.pojo.AmAsset;
import com.ultrapower.utils.PkUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class TestController2 {
    @Autowired
    AmAssetMapper assetMapper;
    @RequestMapping("/test")
    public ModelAndView test(@RequestParam MultipartFile assetExcel) throws IOException {
        InputStream inputStream = assetExcel.getInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        int rows = sheetAt.getPhysicalNumberOfRows();
        for (int i=1;i<rows;i++){
            XSSFRow row = sheetAt.getRow(i);
            AmAsset amAsset = assetVO(row);
            assetMapper.insert(amAsset);
        }
        return null;
    }

    public AmAsset assetVO(XSSFRow row){
        AmAsset amAsset = new AmAsset();
        amAsset.setPkAsset(PkUtils.getPrimaryKey());
        amAsset.setProvCode(row.getCell(0).getStringCellValue());
        amAsset.setAssetCode(row.getCell(2).getStringCellValue());
        amAsset.setAssetName(row.getCell(1).getStringCellValue());
        amAsset.setAssetIp(row.getCell(3).getStringCellValue());
        return amAsset;
    }


    @RequestMapping("/Test1")
    public ResponseEntity<byte[]> poiDownloadTest() throws UnsupportedEncodingException {
        List<AmAsset> amAssets = assetMapper.selectByExample(null);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.getRow(0);
        //省份编码	资产名称	资产编码	资产ip
        row.createCell(0).setCellValue("省份编码");
        row.createCell(1).setCellValue("资产名称");
        row.createCell(2).setCellValue("资产编码");
        row.createCell(3).setCellValue("资产ip");
        for (int i=1;i<amAssets.size()+1;i++){
           // XSSFRow rowAsset = sheet.createRow(i);//表头
            row.createCell(0).setCellValue(amAssets.get(i-1).getProvCode());
            row.createCell(1).setCellValue(amAssets.get(i-1).getAssetName());
            row.createCell(2).setCellValue(amAssets.get(i-1).getAssetCode());
            row.createCell(3).setCellValue(amAssets.get(i-1).getAssetIp());
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            workbook.write(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        String fileName=new String("资产数据.xlsx".getBytes("UTF-8"),"iso-8859-1");
        httpHeaders.setContentDispositionFormData("attachment",fileName);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        ResponseEntity<byte[]> returnFile=new ResponseEntity<byte[]>(byteArrayOutputStream.toByteArray(),httpHeaders,HttpStatus.CREATED);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnFile;
    }

}
