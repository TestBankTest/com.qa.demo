package com.qa.testcases;

import com.qa.pages.PageCheckPayment;
import com.qa.pages.PageOrderConfirmation;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class PageOrderConfirmation_Test extends TestBase {

    ProductInfoExcelUtil productInfoExcelUtil;
    PageOrderConfirmation pageOrderConfirmation;
    SheetNames sheetNames;


    @BeforeClass(groups = {"Sanity"})
    public void setupBeforeClass(){
        this.pageOrderConfirmation=new PageOrderConfirmation(driver);
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),"./testdata/ProductData.xlsx");
    }

    @BeforeMethod
    public void setupBeforeMethod(){
    }

    @Test(groups = {"Sanity"},priority = 44)
    public void TC01(ITestContext iTestContext){
    SoftAssert softAssert=new SoftAssert();
    this.sheetNames=SheetNames.ProductInfoExcel_ProductList;
    softAssert.assertEquals(this.pageOrderConfirmation.doGetText(this.pageOrderConfirmation.getProductAmount()),"$"+String.valueOf(Double.parseDouble(this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),Integer.valueOf(iTestContext.getAttribute("productID").toString())).replace("$",""))+new Double("2.00")));
    softAssert.assertEquals(this.pageOrderConfirmation.doGetText(this.pageOrderConfirmation.getNameAccountOwner()).trim(),"Pradeep Macharla".trim());
    softAssert.assertEquals(this.pageOrderConfirmation.doGetText(this.pageOrderConfirmation.getDetails()),"xyz");
    softAssert.assertEquals(this.pageOrderConfirmation.doGetText(this.pageOrderConfirmation.getBankName()),"RTP");
    iTestContext.setAttribute("referenceNumber",this.pageOrderConfirmation.getReferenceNumber());
    softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 45)
    public void TC02(){
        SoftAssert softAssert=new SoftAssert();
        this.pageOrderConfirmation.clkBtnBackToOrder();
        softAssert.assertEquals(driver.getCurrentUrl().contains("history"),true);
        softAssert.assertAll();
    }

    @AfterMethod
    public void setupAfterMethod(){

    }

    @AfterClass
    public void setupAfterClass(){

    }
















}
