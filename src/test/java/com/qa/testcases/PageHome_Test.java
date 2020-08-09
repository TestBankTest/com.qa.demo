package com.qa.testcases;

import com.qa.pages.PageHome;
import com.qa.pages.PageProductDetails;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ExcelFilesPath;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class PageHome_Test extends TestBase {

    private PageHome pageHome;
    private PageProductDetails pageProductDetails;
    private Boolean productStatus=false;
    private String expectedCurrentUrl;

    @BeforeClass(groups = {"Smoke","Sanity"})
    public void setupBeforeClass(){
        try {
            this.pageHome = new PageHome(this.driver);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    @BeforeMethod
    public void setupBeforeMethod(){
    }

    @Test(enabled = false,groups = {"Smoke"},priority = 0)
    public void verifyLnkLblContactUs(){
            testReportUtil.configureTest("verify_LnkLblContactUs");
            this.expectedCurrentUrl="http://automationpractice.com/index.php?controller=contact";
            this.pageHome.doClick(this.pageHome.getLnkLblContactUs());
            Assert.assertEquals(this.pageHome.doGetCurrentUrl().trim(),expectedCurrentUrl.trim(),"lnkLabel_ContactUs not working.");
    }

    @Test(enabled = false,groups = {"Smoke"},priority = 1)
    public void verifyLnkLblSignIn(){
            testReportUtil.configureTest("verify_LnkLblSignIn");
            this.expectedCurrentUrl="http://automationpractice.com/index.php?controller=authentication&back=my-account";
            pageHome.doClick(this.pageHome.getLnkLblSignIn());
            Assert.assertEquals(this.pageHome.doGetCurrentUrl().trim(),this.expectedCurrentUrl.trim(),"lnkLabel_SignIn not working.");
    }

    @Test(enabled = false,groups = {"Smoke"},dataProvider = "PopularProductList",priority = 2)
    public void verifyPopularProductList(String productName,String productPrice){
            SoftAssert softAssert=new SoftAssert();
            testReportUtil.configureTest("verify_PopularProductList");
            this.productStatus=false;
            if(this.pageHome.getProductAvailabilityStatus(productName,productPrice)==1){
                this.productStatus=true;
            }else {
                this.productStatus=false;
            }
        softAssert.assertTrue(productStatus,productName+" product not found on home page.");
        softAssert.assertAll();
    }
    @DataProvider(name = "PopularProductList")
    public Object[][] getPopularProductList(){
        Object [][]popularProductList=null;
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        return  popularProductList=this.productInfoExcelUtil.getPopularProductNameAndProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),0);
    }


    @Test(enabled = true,groups = {"Smoke"},dataProvider = "ProductName")
    public void verifyBtnMore(String productName){
        SoftAssert softAssert=new SoftAssert();
        this.pageProductDetails=this.pageHome.clkBtnMore(productName.trim());
        softAssert.assertEquals(this.pageProductDetails.getLblPName().isDisplayed(),true);
        softAssert.assertAll();
    }
    @DataProvider(name = "ProductName")
    public Object[][] getProductName(){
        Object [][]ProductName=new Object[1][1];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        ProductName[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),1);
        return ProductName;
    }



    @AfterMethod(enabled = false,groups = {"Smoke"})
    public void setupAfterMethod(ITestResult iTestResult){
        testReportUtil.configureTestResult(iTestResult);
        this.expectedCurrentUrl="http://automationpractice.com/index.php";
            if(!this.driver.getCurrentUrl().trim().equals(this.expectedCurrentUrl.trim())){
                this.driver.navigate().back();
            }
    }

    @AfterClass
    public void setupAfterClass(){

    }












}
