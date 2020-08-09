package com.qa.testcases;

import com.qa.pages.PageAddress;
import com.qa.pages.PageAuthentication;
import com.qa.pages.PageForgotYourPassword;
import com.qa.pages.PageSignIn;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class PageSignIn_Test extends TestBase {

    PageSignIn pageSignIn;
    PageAddress pageAddress;
    PageAuthentication pageAuthentication;
    ProductInfoExcelUtil productInfoExcelUtil;
    SheetNames sheetNames;
    PageForgotYourPassword pageForgotYourPassword;
    @BeforeClass(groups = {"Sanity"})
    public void setupBeforeClass(){
        this.pageSignIn=new PageSignIn(driver);
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),"./testdata/ProductData.xlsx");

    }

    @BeforeMethod(groups = {"Sanity"})
    public void setupBeforeMethod(){
        this.pageSignIn.doClear(this.pageSignIn.getTxtEmailAddress());
        this.pageSignIn.doClear(this.pageSignIn.getTxtEmailAddressTwo());
        this.pageSignIn.doClear(this.pageSignIn.getTxtPassword());
    }


    @Test(groups = {"Sanity"},priority = 17)
    public void TC01(){
        SoftAssert softAssert=new SoftAssert();
        this.pageSignIn.passEmailAddress("testappium003@gmail.com");
        this.pageSignIn.clkBtnCreateAccount(driver);
        Assert.assertEquals(this.pageSignIn.getAvailabilityStatusOfAlertEmailAddressAlreadyUsed().size()>0,true,"Alert message not showed");
        softAssert.assertEquals(this.pageSignIn.getAlertEmailAddressAlreadyUsed().isDisplayed(),true,"Alert message not display correctly");
        softAssert.assertEquals(this.pageSignIn.doGetText(this.pageSignIn.getAlertEmailAddressAlreadyUsed()).trim(),"An account using this email address has already been registered. Please enter a valid password or request a new one. ".trim(),"error message has show correctly");
        softAssert.assertAll();
    }



    @Test(groups = {"Sanity"},priority = 18)
    public void TC02(){
        SoftAssert softAssert=new SoftAssert();
        this.pageSignIn.clkBtnCreateAccount(driver);
        softAssert.assertEquals(this.pageSignIn.doGetText(this.pageSignIn.getAlertInvalidEmailAddress()).trim(),"Invalid email address.".trim(),"Alert message not display correctly");

    }

    @Test(groups = {"Sanity"},priority = 19,enabled = false)
    public void TC03() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        this.pageSignIn.passEmailAddress("testappium004@gmail.com");
        this.pageAuthentication=this.pageSignIn.clkBtnCreateAccount(driver);
        Thread.sleep(5000);
        jsHandleUtil.doScrollTo(0,0);
        softAssert.assertEquals(this.pageAuthentication.getLblAuthentication().isDisplayed(),true,"User not redirect on Authentication page");
        softAssert.assertAll();
        driver.navigate().back();
    }

    @Test(groups = {"Sanity"},priority = 20)
    public void TC04() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        this.pageSignIn.clkBtnSignIn(driver);
        Thread.sleep(200);
        jsHandleUtil.doScrollTo(0,500);
        softAssert.assertEquals(this.pageSignIn.getAlertAnEmailAddressRequired().isDisplayed(),true,"Alert message not display correctly");
        softAssert.assertEquals(this.pageSignIn.doGetText(this.pageSignIn.getAlertAnEmailAddressRequired()).trim(),"An email address required.".trim(),"error message has show correctly");
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 21)
    public void TC05() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        this.pageSignIn.passEmailAddressTwo("testappium003@gmail.com");
        this.pageSignIn.clkBtnSignIn(driver);
        Thread.sleep(200);
        jsHandleUtil.doScrollTo(0,500);
        softAssert.assertEquals(this.pageSignIn.getAlertPasswordIsRequired().isDisplayed(),true,"Alert message not display correctly");
        softAssert.assertEquals(this.pageSignIn.doGetText(this.pageSignIn.getAlertPasswordIsRequired()).trim(),"Password is required.".trim(),"error message has show correctly");
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 22,enabled = true)
    public void TC06() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        this.pageSignIn.passEmailAddress("Password");
        this.pageSignIn.clkBtnSignIn(driver);
        Thread.sleep(200);
        jsHandleUtil.doScrollTo(0,500);
        softAssert.assertEquals(this.pageSignIn.getAlertAnEmailAddressRequired().isDisplayed(),true,"Alert message not display correctly");
        softAssert.assertEquals(this.pageSignIn.doGetText(this.pageSignIn.getAlertAnEmailAddressRequired()).trim(),"An email address required.".trim(),"error message has show correctly");
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 23,enabled = true)
    public void TC07() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        this.pageSignIn.passEmailAddressTwo("testappium003@gmail.com");
        this.pageSignIn.passEmailPassword("Password");
        this.pageSignIn.clkBtnSignIn(driver);
        Thread.sleep(200);
        jsHandleUtil.doScrollTo(0,500);
        softAssert.assertEquals(this.pageSignIn.getAlertAuthenticationFailed().isDisplayed(),true,"Alert message not display correctly");
        softAssert.assertEquals(this.pageSignIn.doGetText(this.pageSignIn.getAlertAuthenticationFailed()).trim(),"Authentication failed.".trim(),"error message has show correctly");
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 24,enabled = true)
    public void TC08() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        this.pageForgotYourPassword=this.pageSignIn.clkLnkLblForgotYourPassword(driver);
        softAssert.assertEquals(this.pageForgotYourPassword.getLblForgotYourPassword().isDisplayed(),true,"User has not redirect on forgot password page");
        softAssert.assertAll();
        driver.navigate().back();
    }

    @Test(groups = {"Sanity"},priority = 25,enabled = true)
    public void TC09(ITestContext iTestContext) throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        this.pageSignIn.passEmailAddressTwo("testappium003@gmail.com");
        this.pageSignIn.passEmailPassword("Password@123");
        this.pageAddress=this.pageSignIn.clkBtnSignIn(driver);
        this.sheetNames=SheetNames.ProductInfoExcel_UserCredential;
        iTestContext.setAttribute("UserName",this.productInfoExcelUtil.getUserName(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),"testappium003@gmail.com","Password@123"));
        softAssert.assertEquals(this.pageAddress.getLblAddress().isDisplayed(),true,"User has not redirect on address page");
        softAssert.assertAll();
    }


























    @AfterMethod
    public void setupAfterMethod(){

    }

    @AfterClass
    public void setupAfterClass(){

    }




}
