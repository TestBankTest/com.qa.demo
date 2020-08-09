package com.qa.testcases;

import com.qa.pages.PageAddress;
import com.qa.pages.PageHome;
import com.qa.pages.PageSignIn;
import com.qa.pages.PageSummary;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ExcelFilesPath;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class PageSummary_Test extends TestBase {

    private PageSummary pageSummary;
    private PageHome pageHome;
    private PageAddress pageAddress;
    private PageSignIn pageSignIn;

    @BeforeClass(enabled = true,groups = {"Sanity","Smoke"})
    public void setupBeforeClass(){
        this.pageSummary=new PageSummary(driver);
    }
    @BeforeMethod(enabled = true,groups = {"Sanity","Smoke"})
    public void setupBeforeMethod(){

    }

    @Test(enabled = true,groups = {"Sanity"},dataProvider = "TestDataCartProductDetails",priority = 9)
    public void verify_CartProductDetails(String productName,String productPrice,String productColor,String productSize){
        SoftAssert softAssert=new SoftAssert();
        testReportUtil.configureTest("verify_CartProductDetails");
        softAssert.assertEquals(this.pageSummary.doGetText(this.pageSummary.getProductName()),productName,"Product Name not matched on Summary page");
        softAssert.assertEquals(this.pageSummary.getProductColor().replace(":","").trim(),productColor,"Product Color not matched on Summary page");
        softAssert.assertEquals(this.pageSummary.getProductSize().replace(":","").trim(),productSize,"Product Size not matched on Summary page");
        softAssert.assertEquals(this.pageSummary.doGetText(this.pageSummary.getProductUnitPrice()),productPrice,"Product Price not matched on Summary page");
        softAssert.assertEquals(this.pageSummary.getProductQuantity(),Integer.valueOf(1),"Product Name not matched on Summary page");
        softAssert.assertAll();
    }
    @DataProvider(name = "TestDataCartProductDetails")
    public Object[][] getTestDataCartProductDetails(ITestContext iTestContext){
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        System.out.println("Now product Is is " +Integer.valueOf(iTestContext.getAttribute("productID").toString()));
        return this.productInfoExcelUtil.getProductInfo(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),Integer.valueOf(iTestContext.getAttribute("productID").toString()));
    }

    @Test(enabled = true,groups = {"Sanity"},dataProvider = "TestDataProductDetails",priority = 10)
    public void verify_ProductDetails(String productName,ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        testReportUtil.configureTest("verify_ProductDetails");
        softAssert.assertEquals(this.pageSummary.getProductQuantity(),iTestContext.getAttribute(productName),"Product quantity not matched");
        softAssert.assertEquals(this.pageSummary.doGetText(this.pageSummary.getProductTotal()),"$"+String.valueOf(Double.parseDouble(this.pageSummary.doGetText(this.pageSummary.getProductUnitPrice()).replace("$","").trim())*this.pageSummary.getProductQuantity()),"product total count not matched");
        softAssert.assertEquals(this.pageSummary.doGetText(this.pageSummary.getTotalProductPrice()),this.pageSummary.doGetText(this.pageSummary.getProductTotal()),"Total product price not matched");
        softAssert.assertEquals(this.pageSummary.doGetText(this.pageSummary.getProductTotalShippingCost()),"$2.00","Shipping cost not matched");
        softAssert.assertEquals("$"+String.valueOf(Double.parseDouble(this.pageSummary.doGetText(this.pageSummary.getTotalProductPrice()).replace("$","").trim())+Double.parseDouble(this.pageSummary.doGetText(this.pageSummary.getProductTotalShippingCost()).replace("$",""))),this.pageSummary.doGetText(this.pageSummary.getTotalPrice()),"Total price not matched");
        softAssert.assertEquals(this.pageSummary.doGetText(this.pageSummary.getProductTotalTax()),"$0.00","Tax amount not matched");
        softAssert.assertEquals("$"+String.valueOf(Double.parseDouble(this.pageSummary.doGetText(this.pageSummary.getTotalPrice()).replace("$","").trim())+Double.parseDouble(this.pageSummary.doGetText(this.pageSummary.getProductTotalTax()).replace("$",""))),this.pageSummary.doGetText(this.pageSummary.getProductFinalTotal()),"Final amount not matched");
        softAssert.assertAll();
    }
    @DataProvider(name = "TestDataProductDetails")
    public Object[][] getTestDataProductDetails(ITestContext iTestContext){
        Object[][]data=new Object[1][1];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        System.out.println("Now product Is is " +Integer.valueOf(iTestContext.getAttribute("productID").toString()));
        data[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),Integer.valueOf(iTestContext.getAttribute("productID").toString()));
        return data;
    }

    @Test(enabled = true,groups = {"Sanity"},priority = 11)
    public void verify_ProductCount(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        testReportUtil.configureTest("verify_ProductCount");
        softAssert.assertEquals(this.pageSummary.getProductCount(),iTestContext.getAttribute("productQuantity"),"Product count not matched");
        softAssert.assertAll();
    }

    @Test(enabled = true,groups = {"Sanity"},dataProvider = "TestDataProductAvailabilityStatus",priority = 12)
    public void verify_ProductAvailabilityStatus(String productName,String productPrice,String productAvailabilityStatus){
        SoftAssert softAssert=new SoftAssert();
        testReportUtil.configureTest("verify_ProductAvailabilityStatus");
        softAssert.assertEquals(this.pageSummary.doGetText(this.pageSummary.getProductName()),productName,"Product Name not matched on Summary page");
        softAssert.assertEquals(this.pageSummary.doGetText(this.pageSummary.getProductUnitPrice()),productPrice,"Product Price not matched on Summary page");
        softAssert.assertEquals(this.pageSummary.doGetText(this.pageSummary.getProductStockStatus()),productAvailabilityStatus,"product availability status not matched");
        softAssert.assertAll();
    }
    @DataProvider(name = "TestDataProductAvailabilityStatus")
    public Object[][] getTestDataProductAvailabilityStatus(ITestContext iTestContext){
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        return this.productInfoExcelUtil.getPopularProductNameAndProductPriceAndProductAvailabilityStatus(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),Integer.valueOf(iTestContext.getAttribute("productID").toString()));
    }

    @Test(enabled = true,groups = {"Sanity"},priority = 13)
    public void verify_ContinueShoppingFeature() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        testReportUtil.configureTest("verify_ContinueShoppingFeature");
        this.pageSummary.clkBtnContinueShopping();
        softAssert.assertEquals(this.pageSummary.doGetCurrentUrl(),"http://automationpractice.com/index.php","User has not redirect/navigate to home page");
        softAssert.assertAll();
        if(this.pageSummary.doGetCurrentUrl().equals("http://automationpractice.com/index.php"))
        { driver.navigate().back();}
    }

    @Test(groups = {"Sanity"},enabled = true,priority = 14)
    public void verify_ProceedToCheckOutFeature() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        testReportUtil.configureTest("verify_ProceedToCheckOutFeature");
        this.pageSummary.clkBtnProceedToCheckOut();
        jsHandleUtil.doScrollTo(0,0);
        this.pageHome=new PageHome(driver);
        if(this.pageHome.getLnkLblSignOutPresenceStatus()==1){
            this.pageAddress=new PageAddress(driver);
          softAssert.assertEquals(this.pageAddress.getLblAddress().isDisplayed(),true,"User not redirect on address page");
        }else if(this.pageHome.getLnkLblSignInPresenceStatus()==1){
            this.pageSignIn=new PageSignIn(driver);
            softAssert.assertEquals(this.pageSignIn.getLblAuthentication().isDisplayed(),true,"User not redirect on Authentication page");
        }else{
            softAssert.assertTrue(false,"User not redirect on required page after click on Proceed to checkout from summary page");
        }
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},enabled = false,priority = 15)
    public void verify_RemoveProductFeature() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        testReportUtil.configureTest("verify_RemoveProductFeature");
        this.pageSummary.clkBtnRemoveProduct();
        Thread.sleep(2000);
        if(this.pageSummary.getPresenceOfAlertLblYourShoppingCartIsEmpty().size()>0){
            if(jsHandleUtil.getPageXOffset().intValue()<1000) {
                jsHandleUtil.doScrollTo(0, 500);
                softAssert.assertEquals(this.pageSummary.getAlertLblYourShoppingCartIsEmpty().isDisplayed(), true, "Shopping cart empty error message not showed");
                softAssert.assertEquals(this.pageSummary.doGetText(this.pageSummary.getAlertLblYourShoppingCartIsEmpty()), "Your shopping cart is empty.", "Shopping cart error message is not matched with expected error message ");
            }
            }else{
            softAssert.assertTrue(false,"Product has not removed from summary page");
        }
      softAssert.assertAll();
    }

    @AfterMethod
    public void setupAfterMethod(ITestResult iTestResult){
        testReportUtil.configureTestResult(iTestResult);


    }

    @AfterClass
    public void setupAfterClass(){

    }
}
