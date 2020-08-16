package com.qa.testcases;

import com.qa.pages.*;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ExcelFilesPath;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class PageProductDetails_Test extends TestBase {

    PageProductDetails pageProductDetails;
    PageProductCartView pageProductCartView;
    PageSignIn pageSignIn;
    PageHome pageHome;
    PageCart pageCart;
    BigDecimal bigDecimal;


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

    @Test(groups = {"Smoke"},dataProvider = "ProductPrice",priority = 2)
    public void verifyProductPrice(String productPrice){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pageProductDetails.getProductPrice(),Double.parseDouble(productPrice.replace("$","").trim()));
        softAssert.assertAll();
    }
    @DataProvider(name = "ProductPrice")
    public Object[][] getProductPrice(){
        Object [][]ProductPrice=new Object[1][1];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        ProductPrice[0][0]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),1);
        return ProductPrice;
    }

    @Test(groups = {"Smoke"},priority = 3)
    public void verifyProductColor(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        Integer productCount=1;
        for(int i=0;i<this.pageProductDetails.getAllProductColor().size();i++){
            this.pageProductDetails.selectProductColor(this.pageProductDetails.getAllProductColor().get(i));
            iTestContext.setAttribute("productColor",this.pageProductDetails.getAllProductColor().get(i).trim());
            Integer productImageSize=this.pageProductDetails.getProductImages().size();

            for(int j=0;j<productImageSize;j++){
                if(this.pageProductDetails.getAllProductImageNames().get(j).contains(String.valueOf(productCount))){
                    productCount=productCount+1;
                }
            }
        }

        softAssert.assertAll();
    }

    @Test(groups = {"Smoke"},enabled = true,priority = 4,dataProvider = "ProductQuantity")
    public void verifyProductQuantity(Integer quantityCount, ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        Integer currentQuantityCount=this.pageProductDetails.getProductQuantity();
        if(quantityCount>currentQuantityCount){
            for(int i=currentQuantityCount;i<quantityCount;i++){
                this.pageProductDetails.clickBtnQuantityPlus();
            }
        }else if(quantityCount<currentQuantityCount){
            for(int i=currentQuantityCount;i<quantityCount;i++){
                this.pageProductDetails.clkBtnQuantityMinus();
            }
        }
        iTestContext.setAttribute("productQuantity",this.pageProductDetails.getProductQuantity());
        System.out.println("getu " +iTestContext.getAttribute("productQuantity"));
        softAssert.assertEquals(this.pageProductDetails.getProductQuantity(),quantityCount);
        softAssert.assertAll();


    }
    @DataProvider(name = "ProductQuantity")
    public Object[][] getProductQuantity(){
        Object [][]ProductPrice=new Object[1][1];
        ProductPrice[0][0]=5;
        return ProductPrice;
    }

    @Test(groups = {"Smoke"},enabled = true,priority = 5,dataProvider = "ProductSize")
    public void verifyProductSize(String productSize,ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        this.pageProductDetails.selectSize(productSize);
        iTestContext.setAttribute("productSize",this.pageProductDetails.getSize());
        softAssert.assertEquals(this.pageProductDetails.getSize(),productSize);
        softAssert.assertAll();

    }
    @DataProvider(name = "ProductSize")
    public Object[][] getProductSize(){
        Object [][]ProductPrice=new Object[1][1];
        ProductPrice[0][0]="L";
        return ProductPrice;
    }

    @Test(groups = {"Smoke"},enabled = false,priority = 6,dataProvider = "UserCredential")
    public void verifyWishList(HashMap<String,String> userCredential, String productName){
        SoftAssert softAssert=new SoftAssert();
        this.pageProductDetails.clkBtnWishlist();
        System.out.println(this.pageProductDetails.verifyPresenceOfAlert_LogInRequired()+" m " +userCredential.get("Username"));
        if(this.pageProductDetails.verifyPresenceOfAlert_LogInRequired()){
            this.pageProductDetails.clkBtnCloseAlertLogIn();
            this.pageHome=new PageHome(driver);
            this.pageHome.clkLnkLblSignIn();
            this.pageSignIn=new PageSignIn(driver);
            this.pageSignIn.passEmailAddressTwo(userCredential.get("Username"));
            this.pageSignIn.passEmailPassword(userCredential.get("Password"));
            this.pageSignIn.clkBtnSignIn(driver);
            driver.navigate().to("http://automationpractice.com/index.php");
            this.pageHome=new PageHome(driver);
            this.pageHome.clkBtnMore(productName);
            this.pageProductDetails=new PageProductDetails(driver);
            this.pageProductDetails.clkBtnWishlist();
            if(this.pageProductDetails.verifyPresenceOfAlertSuccessfulOfWishList()){
                softAssert.assertEquals(this.pageProductDetails.doGetText(this.pageProductDetails.getAlertSuccessfulOfWishList()).trim(),"Added to your wishlist.".trim());
                this.pageProductDetails.clkBtnCloseAlertLogIn();
            }else{
                softAssert.assertTrue(false);
            }
        }else{
            if(this.pageProductDetails.verifyPresenceOfAlertSuccessfulOfWishList()){
                softAssert.assertEquals(this.pageProductDetails.doGetText(this.pageProductDetails.getAlertSuccessfulOfWishList()).trim(),"Added to your wishlist.".trim());
                this.pageProductDetails.clkBtnCloseAlertLogIn();
            }else{
                softAssert.assertTrue(false);
            }
        }
        softAssert.assertAll();
    }
    @DataProvider(name = "UserCredential")
    public Object[][] getUserCredential(){
        Object [][]ProductPrice=new Object[1][2];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        ProductPrice[0][0]=this.productInfoExcelUtil.getUserCredential(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_UserCredential).getSheetName().toString().trim(),"U001");
        ProductPrice[0][1]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),1);
        return ProductPrice;
    }

    @Test(groups = {"Smoke"},enabled = true,priority = 7)
    public void verifyAddCartView(ITestContext iTestContext) throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        this.pageProductDetails.clkBtnAddToCart();
        this.pageProductCartView=new PageProductCartView(driver);
        softAssert.assertEquals(this.pageProductCartView.getProductColor().trim(),iTestContext.getAttribute("productColor"));
        softAssert.assertEquals(this.pageProductCartView.getProductSize().trim(),iTestContext.getAttribute("productSize"));
        softAssert.assertEquals(Integer.valueOf(this.pageProductCartView.getProductQuantity().trim()),Integer.valueOf(iTestContext.getAttribute("productQuantity").toString()));
        this.pageProductCartView.clkBtnCloseFromCartView();
        softAssert.assertAll();

    }

    @Test(groups = {"Smoke"},enabled = true,priority = 8,dataProvider = "ProductInfoForCartView")
    public void verifyProductDetailsFromCartPage(String productName,String productPrice,ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        bigDecimal= new BigDecimal(Double.parseDouble(productPrice.replace("$",""))*5).setScale(2, RoundingMode.HALF_UP);
        productPrice= "$"+String.valueOf(bigDecimal.doubleValue());

        this.pageHome=new PageHome(driver);
        actionsHandleUtil.moveElement(this.pageHome.getLnkLblCart());
        this.pageCart = new PageCart(this.driver);
        this.pageCart.clkBtnRemove(productName,productPrice);

        if(!this.pageCart.doGetText(this.pageCart.getCartProductCount()).equals("")){
            this.pageCart.doClick(this.pageCart.getCartProductCount());
            driver.navigate().back();
        }

        this.pageProductDetails.clkBtnAddToCart();
        this.pageProductCartView=new PageProductCartView(driver);
        this.pageProductCartView.clkBtnCloseFromCartView();
        this.pageHome=new PageHome(driver);
        actionsHandleUtil.moveElement(this.pageHome.getLnkLblCart());
        this.pageCart = new PageCart(this.driver);
        softAssert.assertEquals(this.pageCart.getCartProductColor(productName,productPrice).trim(),iTestContext.getAttribute("productColor"));
        softAssert.assertEquals(this.pageCart.getCartProductSize(productName,productPrice).trim(),iTestContext.getAttribute("productSize"));
        softAssert.assertEquals(Integer.valueOf(this.pageCart.doGetText(this.pageCart.getCartProductQuantity(productName,productPrice)).trim().replace("$","")),Integer.valueOf(iTestContext.getAttribute("productQuantity").toString()));
        softAssert.assertAll();
    }

    @DataProvider(name="ProductInfoForCartView")
    public Object[][] getProductInfoForCartView(){
        Object [][]ProductInfo=new Object[1][2];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        ProductInfo[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),1);
        ProductInfo[0][1]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().toString().trim(),1);
        return ProductInfo;
    }


























    @AfterMethod(enabled = true,groups = {"Smoke"})
    public void setupAfterMethod(ITestResult iTestResult){
    }

    @AfterClass
    public void setupAfterClass(){

    }






}
