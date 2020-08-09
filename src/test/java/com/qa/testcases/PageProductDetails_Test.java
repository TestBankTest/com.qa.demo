package com.qa.testcases;

import com.qa.pages.PageHome;
import com.qa.pages.PageProductDetails;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ExcelFilesPath;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class PageProductDetails_Test extends TestBase {

    PageProductDetails pageProductDetails;
    @BeforeClass(groups = {"Smoke","Sanity"})
    public void setupBeforeClass(){
        try {
            this.pageProductDetails = new PageProductDetails(this.driver);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    @BeforeMethod
    public void setupBeforeMethod(){
    }

    @Test(groups = {"Smoke"},dataProvider = "HeaderProductName",priority = 0)
    public void verifyProductNameFromHeader(String productName){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pageProductDetails.doGetText(this.pageProductDetails.getLblProductName()).split(">")[4].trim(),productName);
        softAssert.assertAll();
    }
    @DataProvider(name = "HeaderProductName")
    public Object[][] getProductNameForHeader(){
        Object [][]ProductName=new Object[1][1];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        ProductName[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),1);
        return ProductName;
    }

    @Test(groups = {"Smoke"},dataProvider = "ProductName",priority = 1)
    public void verifyProductName(String productName){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pageProductDetails.doGetText(this.pageProductDetails.getLblPName()),productName);
        softAssert.assertAll();
    }
    @DataProvider(name = "ProductName")
    public Object[][] getProductName(){
        Object [][]ProductName=new Object[1][1];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        ProductName[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),1);
        return ProductName;
    }

    @Test
    public void verifyProductPrice(){

    }











    @AfterMethod(enabled = true,groups = {"Smoke"})
    public void setupAfterMethod(ITestResult iTestResult){
    }

    @AfterClass
    public void setupAfterClass(){

    }






}
