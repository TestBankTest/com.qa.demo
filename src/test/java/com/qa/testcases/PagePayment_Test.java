package com.qa.testcases;

import com.qa.pages.PageBankWirePayment;
import com.qa.pages.PageCheckPayment;
import com.qa.pages.PagePayment;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class PagePayment_Test extends TestBase {

    PagePayment pagePayment;
    PageBankWirePayment pageBankWirePayment;
    PageCheckPayment pageCheckPayment;
    ProductInfoExcelUtil productInfoExcelUtil;
    SheetNames sheetNames;


    @BeforeClass(groups = {"Sanity"})
    public void setupBeforeClass(){
        this.pagePayment=new PagePayment(driver);
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),"./testdata/ProductData.xlsx");
    }

    @BeforeMethod(groups = {"Sanity"})
    public void setupBeforeMethod(){

    }

    @Test(groups = {"Sanity"},dataProvider = "Data",priority = 38)
    public void TC01(String productName,String productColor,String productSize,String availabilityStatus,String productPrice){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pagePayment.doGetText(this.pagePayment.getProductName()).trim(),productName);
        softAssert.assertEquals(this.pagePayment.getProductColor().trim(),productColor);
        softAssert.assertEquals(this.pagePayment.getProductSize(),productSize);
        softAssert.assertEquals(this.pagePayment.doGetText(this.pagePayment.getProductStockStatus()).trim(),availabilityStatus);
        softAssert.assertEquals(this.pagePayment.doGetText(this.pagePayment.getProductUnitPrice()).trim(),productPrice);

        softAssert.assertEquals(Integer.valueOf(this.pagePayment.doGetText(this.pagePayment.getProductQuantity())),Integer.valueOf("1"));

        softAssert.assertEquals("$"+String.valueOf(Double.parseDouble(this.pagePayment.doGetText(this.pagePayment.getProductQuantity()))*Double.parseDouble(this.pagePayment.doGetText(this.pagePayment.getProductUnitPrice()).replace("$",""))).trim(),this.pagePayment.doGetText(this.pagePayment.getProductTotalPrice()).trim());

        softAssert.assertEquals(this.pagePayment.doGetText(this.pagePayment.getTotalProductPrice()).trim(),this.pagePayment.doGetText(this.pagePayment.getTotalProductPrice()).trim());

        softAssert.assertEquals(this.pagePayment.doGetText(this.pagePayment.getProductTotalShippingCost()).trim(),"$2.00");

        softAssert.assertEquals(this.pagePayment.doGetText(this.pagePayment.getProductFinalTotal()).trim(),"$"+String.valueOf(Double.parseDouble(this.pagePayment.doGetText(this.pagePayment.getTotalProductPrice()).replace("$",""))+Double.parseDouble(this.pagePayment.doGetText(this.pagePayment.getProductTotalShippingCost()).replace("$",""))));


        softAssert.assertAll();

    }

    @DataProvider(name = "Data")
    public Object[][] getData(ITestContext iTestContext){
        this.sheetNames= SheetNames.ProductInfoExcel_ProductList;
        Object[][] DATA=new Object[1][5];
        DATA[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),Integer.valueOf(iTestContext.getAttribute("productID").toString()));
        DATA[0][1]=this.productInfoExcelUtil.getProductColor(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),Integer.valueOf(iTestContext.getAttribute("productID").toString()));
        DATA[0][2]=this.productInfoExcelUtil.getProductSize(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),Integer.valueOf(iTestContext.getAttribute("productID").toString()));
        DATA[0][3]=this.productInfoExcelUtil.getProductAvailabilityStatus(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),Integer.valueOf(iTestContext.getAttribute("productID").toString()));
        DATA[0][4]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),Integer.valueOf(iTestContext.getAttribute("productID").toString()));
        return DATA;
    }


    @Test(groups = {"Sanity"},priority = 39)
    public void TC02(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        this.pagePayment.clkBtnPayByBankWire();
        this.pageBankWirePayment=new PageBankWirePayment(driver);
        iTestContext.setAttribute("paymentType","Bank wire");
        softAssert.assertEquals(this.pageBankWirePayment.getLblBankWirePayment().isDisplayed(),true);
        softAssert.assertAll();

    }

    @Test(groups = {"Sanity"},priority = 40,enabled = false)
    public void TC03(){
        SoftAssert softAssert=new SoftAssert();
        this.pagePayment.clkBtnPayByCheck();
        this.pageCheckPayment=new PageCheckPayment(driver);
        softAssert.assertEquals(this.pageCheckPayment.getLblCheckPayment().isDisplayed(),true);
        softAssert.assertAll();
        driver.navigate().back();


    }



    @AfterMethod
    public void setupAfterMethod(){

    }

    @AfterClass
    public void setupAfterClass(){

    }








}
