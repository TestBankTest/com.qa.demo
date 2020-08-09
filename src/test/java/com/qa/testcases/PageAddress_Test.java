package com.qa.testcases;

import com.qa.pages.PageAddress;
import com.qa.pages.PageShipping;
import com.qa.pages.PageYourAddress;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class PageAddress_Test extends TestBase {

    PageAddress pageAddress;
    ProductInfoExcelUtil productInfoExcelUtil;
    SheetNames sheetNames;
    PageYourAddress pageYourAddress;
    PageShipping pageShipping;

    @BeforeClass(groups = {"Sanity"})
    public void setupBeforeClass(){
     this.pageAddress=new PageAddress(driver);
     this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),"./testdata/ProductData.xlsx");
    }
    @BeforeMethod(groups = {"Sanity"})
    public void setupBeforeMethod(){
    }

    @Test(groups = {"Sanity"},priority = 27,enabled = true)
    public void TC01()  {
        SoftAssert softAssert=new SoftAssert();
        this.pageAddress.clkChkDeliveryAddress();
        webDriverWait.until(ExpectedConditions.invisibilityOf(this.pageAddress.getLoader()));
        softAssert.assertEquals(this.pageAddress.getLblBillingAddress().isDisplayed(),true,"Add new Address button not visible");
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 28,enabled = true)
    public void TC02() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        this.pageAddress.clkChkDeliveryAddress();
        Thread.sleep(5000);
        softAssert.assertEquals(this.pageAddress.getLblBillingAddress().isDisplayed(),false,"Add new Address button not visible");
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 29,dataProvider = "Data")
    public void TC03(String firstName,String lastName,String companyName,String address,String addressLineTwo,String city,String State,Integer postalNo,String CountryName,Integer homeNumber,Long mobileNumber,ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        dropdownHandleUtil.selectValue(this.pageAddress.getDDDeliveryAddress(),"Address");
        iTestContext.setAttribute("Delivery Address","Address");
        softAssert.assertEquals(this.pageAddress.getFirstNameFromDA().trim(),firstName);
        softAssert.assertEquals(this.pageAddress.getLastNameFromDA().trim(),lastName);
        softAssert.assertEquals(this.pageAddress.getCompanyNameFromDA().trim(),companyName);
        softAssert.assertEquals(this.pageAddress.getAddressFromDA().trim(),address);
        softAssert.assertEquals(this.pageAddress.getAddressLineTwoFromDA().trim(),addressLineTwo);
        softAssert.assertEquals(this.pageAddress.getCityFromDA().trim(),city);
        softAssert.assertEquals(this.pageAddress.getStateFromDA().trim(),State);
        softAssert.assertEquals(Integer.valueOf(this.pageAddress.getPostalNoFromDA()),postalNo);
        softAssert.assertEquals(this.pageAddress.getCountryNameFromDA().trim(),CountryName);
        softAssert.assertEquals(Integer.valueOf(this.pageAddress.getHomeNumberFromDA()),homeNumber);
        softAssert.assertEquals(Long.valueOf(this.pageAddress.getMobileNumberFromDA().trim()),mobileNumber);
        softAssert.assertAll();
    }
    @DataProvider(name = "Data")
    public Object[][] getData(){
        this.sheetNames=SheetNames.ProductInfoExcel_UserDetails;
        Object[][] data=new Object[1][11];
        data[0][0]=this.productInfoExcelUtil.getFirstName(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        data[0][1]=this.productInfoExcelUtil.getLastName(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        data[0][2]=this.productInfoExcelUtil.getCompanyName(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        data[0][3]=this.productInfoExcelUtil.getAddress(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        data[0][4]=this.productInfoExcelUtil.getAddressLineTwo(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        data[0][5]=this.productInfoExcelUtil.getCity(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        data[0][6]=this.productInfoExcelUtil.getState(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        data[0][7]=this.productInfoExcelUtil.getPostalCode(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        data[0][8]=this.productInfoExcelUtil.getCountryName(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        data[0][9]=this.productInfoExcelUtil.getHomeNumber(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        data[0][10]=this.productInfoExcelUtil.getMobileNumber(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),1);
        return data;
    }

    @Test(groups = {"Sanity"},enabled = true,dataProvider = "DataTwo",priority = 30)
    public void TC04(String firstName,String lastName,String companyName,String address,String addressLineTwo,String city,String State,Integer postalNo,String CountryName,Integer homeNumber,Long mobileNumber){
        SoftAssert softAssert=new SoftAssert();
        if(this.pageAddress.getChkDeliveryAddress().isSelected()){
            this.pageAddress.doClick(this.pageAddress.getChkDeliveryAddress());
        }
        dropdownHandleUtil.selectValue(this.pageAddress.getDDBillingAddress(),"My Address");
        softAssert.assertEquals(this.pageAddress.getFirstNameFromBA().trim(),firstName);
        softAssert.assertEquals(this.pageAddress.getLastNameFromBA().trim(),lastName);
        softAssert.assertEquals(this.pageAddress.getCompanyNameFromBA().trim(),companyName);
        softAssert.assertEquals(this.pageAddress.getAddressFromBA().trim(),address);
        softAssert.assertEquals(this.pageAddress.getAddressLineTwoFromBA().trim().replace(".",""),addressLineTwo);
        softAssert.assertEquals(this.pageAddress.getCityFromBA().trim(),city);
        softAssert.assertEquals(this.pageAddress.getStateFromBA().trim(),State);
        softAssert.assertEquals(Integer.valueOf(this.pageAddress.getPostalNoFromBA()),postalNo);
        softAssert.assertEquals(this.pageAddress.getCountryNameFromBA().trim(),CountryName);
        softAssert.assertEquals(Integer.valueOf(this.pageAddress.getHomeNumberFromBA()),homeNumber);
        softAssert.assertEquals(Long.valueOf(this.pageAddress.getMobileNumberFromBA().trim()),mobileNumber);
        softAssert.assertAll();
    }
    @DataProvider(name = "DataTwo")
    public Object[][] getDataTwo(){
        this.sheetNames=SheetNames.ProductInfoExcel_UserDetails;
        Object[][] data=new Object[1][11];
        data[0][0]=this.productInfoExcelUtil.getFirstName(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        data[0][1]=this.productInfoExcelUtil.getLastName(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        data[0][2]=this.productInfoExcelUtil.getCompanyName(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        data[0][3]=this.productInfoExcelUtil.getAddress(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        data[0][4]=this.productInfoExcelUtil.getAddressLineTwo(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        data[0][5]=this.productInfoExcelUtil.getCity(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        data[0][6]=this.productInfoExcelUtil.getState(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        data[0][7]=this.productInfoExcelUtil.getPostalCode(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        data[0][8]=this.productInfoExcelUtil.getCountryName(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        data[0][9]=this.productInfoExcelUtil.getHomeNumber(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        data[0][10]=this.productInfoExcelUtil.getMobileNumber(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),2);
        return data;
    }


    @Test(groups = {"Sanity"},enabled = true,priority = 31)
    public void TC05(){
        SoftAssert softAssert=new SoftAssert();
        this.pageYourAddress=this.pageAddress.clkBtnAddNewAddressTwo();
        softAssert.assertEquals(this.pageYourAddress.getLblYourAddress().isDisplayed(),true);
        softAssert.assertAll();
        driver.navigate().back();
    }

    @Test(groups = {"Sanity"},enabled = true,priority = 32)
    public void TC06(){
        SoftAssert softAssert=new SoftAssert();
        this.pageYourAddress.clkBtnProceedtoCheckout();
        this.pageShipping=new PageShipping(driver);
        softAssert.assertEquals(this.pageShipping.getLblShipping().isDisplayed(),true);
        softAssert.assertAll();
    }





















    @AfterMethod(groups = {"Sanity"})
    public void setupAfterMethod(){

    }
    @AfterClass(groups = {"Sanity"})
    public void setupAfterClass(){

    }





}
