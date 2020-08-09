package com.qa.testcases;

import com.qa.pages.PageBankWirePayment;
import com.qa.pages.PageOrderConfirmation;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class PageBankWirePayment_Test extends TestBase {

    ProductInfoExcelUtil productInfoExcelUtil;
    PageBankWirePayment pageBankWirePayment;
    PageOrderConfirmation pageOrderConfirmation;
    SheetNames sheetNames;


    @BeforeClass(groups = {"Sanity"})
    public void setupBeforeClass(){
        this.pageBankWirePayment=new PageBankWirePayment(driver);
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),"./testdata/ProductData.xlsx");
    }

    @BeforeMethod
    public void setupBeforeMethod(){
    }

    @Test(groups = {"Sanity"},priority = 41)
    public void TC01(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        this.sheetNames=SheetNames.ProductInfoExcel_ProductList;
        softAssert.assertEquals(this.pageBankWirePayment.doGetText(this.pageBankWirePayment.getProductAmount()),"$"+String.valueOf(Double.parseDouble(this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),Integer.valueOf(iTestContext.getAttribute("productID").toString())).replace("$",""))+new Double("2.00")));
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 42)
    public void TC02(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pageBankWirePayment.doGetText(this.pageBankWirePayment.getCurrencyType()),"Dollar");
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 43)
    public void TC03(){
        SoftAssert softAssert=new SoftAssert();
        this.pageBankWirePayment.clkBtnConfirmMyOrder();
        this.pageOrderConfirmation=new PageOrderConfirmation(driver);
        softAssert.assertEquals(this.pageOrderConfirmation.getLblOrderConfirmation().isDisplayed(),true);
        softAssert.assertAll();
    }



    @AfterMethod
    public void setupAfterMethod(){

    }

    @AfterClass
    public void setupAfterClass(){

    }










}
