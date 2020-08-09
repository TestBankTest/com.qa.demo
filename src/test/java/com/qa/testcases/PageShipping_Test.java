package com.qa.testcases;

import com.qa.pages.PagePayment;
import com.qa.pages.PageShipping;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ProductInfoExcelUtil;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.security.acl.Group;

public class PageShipping_Test extends TestBase {

    PageShipping pageShipping;
    ProductInfoExcelUtil productInfoExcelUtil;
    PagePayment pagePayment;

    @BeforeClass(groups = {"Sanity"})
    public void setupBeforeClass(){
        this.pageShipping=new PageShipping(driver);
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),"./testdata/ProductData.xlsx");
    }

    @BeforeMethod
    public void setupBeforeMethod(){

    }

    @Test(groups = {"Sanity"},priority = 33)
    public void TC01(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pageShipping.getShippingAddressName(),iTestContext.getAttribute("Delivery Address"));
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 34)
    public void TC02(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pageShipping.doGetText(this.pageShipping.getDeliveryCost()).trim(),"$2.00");
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 35)
    public void TC03() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        if(this.pageShipping.getChkTermsAndCondition().isSelected()){
            this.pageShipping.getChkTermsAndCondition().click();
        }
        this.pageShipping.clkBtnProceedToCheckOut();
        Thread.sleep(500);
        softAssert.assertEquals(this.pageShipping.getAltMsgOfTermsAndCondition().isDisplayed(),true);
        if(this.pageShipping.getAltMsgOfTermsAndCondition().isDisplayed()){
            this.pageShipping.doClick(pageShipping.getBtnCloseAlertMsg());
        }
        Thread.sleep(500);
        if(this.pageShipping.getAvailabilityStatusOfAltMsgOfTermsAndCondition()==1){
            softAssert.assertTrue(false);
        }else{softAssert.assertTrue(true);}
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 36,enabled = true)
    public void TC04() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        this.pageShipping.clkLnkLblTermsAndCondition();
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'fancybox-frame')]")));
        pageShipping=new PageShipping(driver);
        softAssert.assertEquals(this.pageShipping.getLblTermsAndConditionsOfUse().isDisplayed(),true);
        if(this.pageShipping.getLblTermsAndConditionsOfUse().isDisplayed()){
            driver.switchTo().defaultContent();
            this.pageShipping.doClick(pageShipping.getBtnCloseAlertMsg());
        }
        if(pageShipping.getAvailabilityStatusOfBtnCloseAlertMsg()==1){
            softAssert.assertTrue(false);
        }else{
            softAssert.assertTrue(true);
        }

        softAssert.assertAll();

    }

    @Test(groups = {"Sanity"},priority = 37,enabled = true)
    public void TC05(){
        SoftAssert softAssert=new SoftAssert();
        this.pageShipping.clkChkTermsAndCondition();
        this.pageShipping.clkBtnProceedToCheckOut();
        this.pagePayment=new PagePayment(driver);
        softAssert.assertTrue(this.pagePayment.getLblChooseYourPaymentMethod().isDisplayed());
        softAssert.assertAll();
    }


    @AfterMethod
    public void setupAfterMethod(){

    }

    @AfterClass
    public void setupAfterClass(){

    }



}
