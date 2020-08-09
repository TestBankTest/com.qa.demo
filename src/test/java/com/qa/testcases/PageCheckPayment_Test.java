package com.qa.testcases;

import com.qa.pages.PageBankWirePayment;
import com.qa.pages.PageCheckPayment;
import com.qa.pages.PageOrderConfirmation;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PageCheckPayment_Test extends TestBase {

    ProductInfoExcelUtil productInfoExcelUtil;
    PageCheckPayment pageCheckPayment;
    PageOrderConfirmation pageOrderConfirmation;
    SheetNames sheetNames;


    @AfterClass
    public void setupBeforeClass(){
        this.pageCheckPayment=new PageCheckPayment(driver);
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),"./testdata/ProductData.xlsx");
    }

    @BeforeMethod
    public void setupBeforeMethod(){
    }

    @Test
    public void TC01(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        this.sheetNames=SheetNames.ProductInfoExcel_ProductList;
        softAssert.assertEquals(this.pageCheckPayment.getProductAmount(),this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),Integer.valueOf(iTestContext.getAttribute("productID").toString())));
        softAssert.assertAll();

    }

    @Test
    public void TC02(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pageCheckPayment.getCurrencyType(),"Dollar");
        softAssert.assertAll();
    }

    @Test
    public void TC03(){
        SoftAssert softAssert=new SoftAssert();
        this.pageCheckPayment.clkBtnConfirmMyOrder();
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

