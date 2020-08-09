package com.qa.testbase;

import com.qa.base.Base;
import com.qa.testdatautil.ColumnNames;
import com.qa.testdatautil.ExcelFilesPath;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestBase extends Base {


    public ProductInfoExcelUtil productInfoExcelUtil;
    public SheetNames sheetNames;
    @BeforeSuite(groups = {"Smoke","Sanity"})
    public void setupBeforeSuite(){
        try{
           this.setConfigurationFile();
           this.setTestReportUtil().setTestReport();
           this.setWebDriverManager();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    @BeforeTest(groups = {"Smoke","Sanity"})
    public void setupBeforeTest(){
        try{
            this.setPageUtility();
            this.setTestUtility();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    @BeforeTest(groups = {"Smoke","Sanity"})
    public void setupBeforeGroup(){
        try{

        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    @AfterGroups(groups = {"Smoke","Sanity"})
    public void setupAfterGroup(){
        try{

        }catch (Exception ae){
            ae.printStackTrace();
        }
    }



    @AfterTest(groups = {"Smoke","Sanity"},enabled = false)
    public void setupAfterTest(){
        try{
            testReportUtil.flushReport();
            //emailUtil.sendMailWithAttachment();
        }catch (Exception ae){

        }
    }

    @AfterSuite(groups = {"Smoke","Sanity"})
    public void setupAfterSuite(){
        try{

        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public ColumnNames getColumnName(ColumnNames columnNames){
        ColumnNames columnName=null;
        try{
            columnName=columnNames;
        }catch (Exception ae){
            ae.printStackTrace();
        }return columnName;
    }

    public ExcelFilesPath getExcelPath(ExcelFilesPath excelFilesPath){
        ExcelFilesPath excelFilePath=null;
        try{
            excelFilePath=excelFilesPath;
        }catch (Exception ae){
            ae.printStackTrace();
        }return excelFilePath;
    }

    public SheetNames getSheetName(SheetNames sheetNames){
        SheetNames sheetName=null;
        try{
            sheetName=sheetNames;
        }catch (Exception ae){
            ae.printStackTrace();
        }return sheetName;
    }











}
