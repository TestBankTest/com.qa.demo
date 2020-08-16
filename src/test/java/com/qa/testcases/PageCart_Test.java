package com.qa.testcases;

import com.qa.pages.PageCart;
import com.qa.pages.PageHome;
import com.qa.pages.PageProductCartView;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ExcelFilesPath;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class PageCart_Test extends TestBase {

PageHome pageHome;
PageCart pageCart;
PageProductCartView pageProductCartView;
HashMap<String,Double>productInfo;
Integer productCount=0;
double totalAmount=0.0;
double amount=0;
BigDecimal bigDecimal;
String productName="";
String productPrice="";
boolean productStatus=false;

@BeforeClass(enabled = true,groups = {"Smoke","Sanity"})
public void setupBeforeClass(){
    this.pageHome=new PageHome(driver);
    productInfo = new HashMap<>();
}

@BeforeMethod(groups = {"Smoke","Sanity"})
public void setupBeforeMethod() throws InterruptedException {
    this.productCount=0;
    this.totalAmount=0.0;
    actionsHandleUtil.moveElement(this.pageHome.getLnkLblCart());
    this.pageCart=new PageCart(this.driver);

    if(!this.pageCart.doGetText(this.pageCart.getCartProductCount()).equals("")){
        Integer cartProductCount=this.pageCart.getBtnRemoveAllProduct().size();
    for(int i=0;i<cartProductCount;i++){
        this.pageCart.clkBtnRemoveAllProduct(this.pageCart.getBtnRemoveAllProduct().get(i));
        Thread.sleep(5000);
        if(!this.pageCart.doGetText(this.pageCart.getCartProductCount()).equals("")){
            if(Integer.valueOf(this.pageCart.doGetText(this.pageCart.getCartProductCount()))==1){
                this.driver.navigate().refresh();
                this.pageCart.clkBtnRemoveAllProduct(this.pageCart.getBtnRemoveAllProduct().get(i));
            }
        }
    }
    }

}

@Test(enabled = true,groups = {"Smoke"},dataProvider = "testDataProductDetails",priority = 3)
public void verifyProductDetails(String productName,String productPrice,String productColor,String productSize){
    SoftAssert softAssert=new SoftAssert();
    testReportUtil.configureTest("verify_ProductDetails");
    if (this.pageHome.getProductAvailabilityStatus(productName, productPrice) == 1) {
        this.pageHome.clkAddToCart(productName, productPrice).click();
        this.pageProductCartView=new PageProductCartView(driver);
        productStatus = true;
        productCount = productCount + 1;
    }else{ productStatus=false;}

    Assert.assertTrue(productStatus,productName+" Product not found on home page.");
    this.pageProductCartView.clkBtnCloseFromCartView();
    actionsHandleUtil.moveElement(this.pageHome.getLnkLblCart());
    this.pageCart=new PageCart(this.driver);

    if(this.pageCart.getProduct(productName,productPrice) == 1){
        productStatus=true;
    }else{ productStatus=false; }

    Assert.assertTrue(productStatus,productName+" Selected Product not added in cart page.");

    softAssert.assertEquals(Integer.valueOf(this.pageHome.doGetText(this.pageCart.getCartProductQuantity(productName,productPrice))),productCount,"Product quantity not matched on cart view Page.");

    softAssert.assertEquals(Double.parseDouble(this.pageHome.doGetText(this.pageCart.getCartProductPrice(productName)).replace("$","")),Double.parseDouble(productPrice.replace("$","")),"Product price not matched on cart view page");

    softAssert.assertEquals(this.pageCart.getCartProductColor(productName,productPrice).trim(),productColor.trim(),"Product color not matched on cart view page");

    softAssert.assertEquals(this.pageCart.getCartProductSize(productName,productPrice).trim(),productSize.trim(),"Product size not matched on cart view page");

    softAssert.assertAll();
}
@DataProvider(name = "testDataProductDetails")
public Object[][] passTestDataProductDetails(){
    Object[][] data=new Object[1][4];
    this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
    data[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
    data[0][1]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
    data[0][2]=this.productInfoExcelUtil.getProductColor(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
    data[0][3]=this.productInfoExcelUtil.getProductSize(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
    return data;
    }

@Test(enabled = true,groups = {"Smoke"},dataProvider = "testDataShippingCost",priority = 4)
public void verifyShippingCost(String productName,String productPrice) {
        SoftAssert softAssert = new SoftAssert();
        testReportUtil.configureTest("verify_ShippingCost");

        if (this.pageHome.getProductAvailabilityStatus(productName, productPrice) == 1) {
            this.pageHome.clkAddToCart(productName, productPrice).click();
            this.pageProductCartView=new PageProductCartView(driver);
            productStatus = true;
            productCount = productCount + 1;
        }else{productStatus=false;}

        Assert.assertTrue(productStatus,productName+" Product not found on home page");

        this.pageProductCartView.clkBtnCloseFromCartView();
        actionsHandleUtil.moveElement(this.pageHome.getLnkLblCart());
        this.pageCart=new PageCart(this.driver);
        if(this.pageCart.getProduct(productName,productPrice) == 1){
            productStatus=true;
        }else{ productStatus=false; }

        Assert.assertTrue(productStatus,productName+" Product not found on cart view page");
        softAssert.assertEquals(Double.parseDouble(this.pageHome.doGetText(this.pageCart.getShippingCost()).replace("$","")),2.0,"Shipping cost not matched on cart view page");

        softAssert.assertAll();
    }
@DataProvider(name = "testDataShippingCost")
public Object[][] passTestDataShippingCost(){
        Object[][] data=new Object[1][2];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        data[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        data[0][1]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        return data;
    }

@Test(enabled = true,groups = {"Smoke"},dataProvider = "testDataQuantity",priority = 5)
public void verifyProductQuantity(String productName,String productPrice){
    SoftAssert softAssert=new SoftAssert();
    testReportUtil.configureTest("verify_ProductQuantity");

        if (this.pageHome.getProductAvailabilityStatus(productName, productPrice) == 1) {
            this.pageHome.clkAddToCart(productName, productPrice).click();
            this.pageProductCartView=new PageProductCartView(driver);
            productStatus = true;
            productCount = productCount + 1;
        }else{productStatus=false;}

        Assert.assertTrue(productStatus,productName+" Product not found on home page");
        this.pageProductCartView.clkBtnCloseFromCartView();
        actionsHandleUtil.moveElement(this.pageHome.getLnkLblCart());
        this.pageCart=new PageCart(this.driver);

        if(this.pageCart.getProduct(productName,productPrice) == 1){
            productStatus=true;
        }else{
            productStatus=false;
        }

        Assert.assertTrue(productStatus,productName+" Product not found on cart view page");

        softAssert.assertEquals(Integer.valueOf(this.pageHome.doGetText(this.pageCart.getCartProductQuantity(productName,productPrice))),productCount,"Product quantity count not matched on cart view page");
        totalAmount=totalAmount+Double.parseDouble(productPrice.replace("$",""));
        this.pageHome.clkAddToCart(productName, productPrice).click();
        this.pageProductCartView=new PageProductCartView(driver);
        this.pageProductCartView.clkBtnCloseFromCartView();
        productCount=productCount+1;
        totalAmount=totalAmount+Double.parseDouble(productPrice.replace("$",""));
        actionsHandleUtil.moveElement(this.pageHome.getLnkLblCart());
        bigDecimal= new BigDecimal(totalAmount).setScale(2, RoundingMode.HALF_UP);
        amount = bigDecimal.doubleValue();

        softAssert.assertEquals(Integer.valueOf(this.pageCart.doGetText(this.pageCart.getCartProductQuantity(productName,"$"+String.valueOf(amount)))),productCount," Product quantity count not matched on cart view page");
        softAssert.assertAll();
    }
@DataProvider(name = "testDataQuantity")
public Object[][] passTestDataQuantity(){
        Object[][] data=new Object[1][2];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        data[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        data[0][1]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        return data;
    }

@Test(enabled = true,groups = {"Smoke"},dataProvider = "TestDataTotalCost",priority = 6)
public void verifyTotalCost(String productName,String productPrice){
     SoftAssert softAssert=new SoftAssert();
    testReportUtil.configureTest("verify_TotalCost");
        if (this.pageHome.getProductAvailabilityStatus(productName, productPrice) == 1) {
            this.pageHome.clkAddToCart(productName, productPrice).click();
            this.pageProductCartView=new PageProductCartView(driver);
            productStatus = true;
            productCount = productCount + 1;
            productInfo.put(productName, Double.parseDouble(productPrice.replace("$", "")));
            totalAmount = totalAmount +productInfo.get(productName);
        }else {productStatus=false;}
        Assert.assertTrue(productStatus, productName+" Product not found on home page");
        this.pageProductCartView.clkBtnCloseFromCartView();

        if (productCount == 2) {
            actionsHandleUtil.moveElement(this.pageHome.getLnkLblCart());
            this.pageCart = new PageCart(this.driver);
            softAssert.assertEquals(Integer.valueOf(this.pageCart.getCartProductCount().getText()), productCount);
            for (Map.Entry<String, Double> entry : productInfo.entrySet()) {
                if (this.pageCart.getProduct(entry.getKey().toString().trim(), entry.getValue().toString().trim()) == 1) {
                    productStatus = true;
                    this.productName = entry.getKey().toString().trim();
                    this.productPrice = "$" + entry.getValue().toString().trim();
                } else { productStatus = false; }

                Assert.assertTrue(productStatus, productName+" Product not found on cart view page");
            }
            totalAmount = totalAmount + Double.parseDouble(this.pageCart.doGetText(this.pageCart.getShippingCost()).replace("$", ""));
            bigDecimal=new BigDecimal(totalAmount).setScale(2, RoundingMode.HALF_UP);
            amount= bigDecimal.doubleValue();
            softAssert.assertEquals("$" + String.valueOf(Double.parseDouble(this.pageCart.doGetText(this.pageCart.getTotalCost()).replace("$", ""))), "$" + String.valueOf(amount), "Total amount not matched on cart view page");

            softAssert.assertAll();
        }
}
@DataProvider(name = "TestDataTotalCost")
public Object[][] passTestDataTotalCost(){
        Object [][]data=new Object[2][2];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        data[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        data[0][1]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        data[1][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),2);
        data[1][1]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),2);
        return data;
    }

@Test(enabled = true,groups = {"Smoke"},dataProvider = "TestDataRemoveProduct",priority = 7)
public void verifyRemoveProduct(String productName,String productPrice) throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    testReportUtil.configureTest("verify_RemoveProduct");
        if (this.pageHome.getProductAvailabilityStatus(productName, productPrice) == 1) {
            this.pageHome.clkAddToCart(productName, productPrice).click();
            this.pageProductCartView=new PageProductCartView(driver);
            productStatus = true;
            productCount = productCount + 1;
            productInfo.put(productName, Double.parseDouble(productPrice.replace("$", "")));
            totalAmount = totalAmount + productInfo.get(productName);
        }else{productStatus=false;}

        Assert.assertTrue(productStatus, productName+" Product not found on home page");
        this.pageProductCartView.clkBtnCloseFromCartView();

        if (productCount == 2) {
            actionsHandleUtil.moveElement(this.pageHome.getLnkLblCart());
            this.pageCart = new PageCart(this.driver);
            softAssert.assertEquals(Integer.valueOf(this.pageCart.doGetText(this.pageCart.getCartProductCount())), productCount);
            for (Map.Entry<String, Double> entry : productInfo.entrySet()) {
                if (this.pageCart.getProduct(entry.getKey().toString().trim(), entry.getValue().toString().trim()) == 1) {
                    productStatus = true;
                    this.productName = entry.getKey().toString().trim();
                    this.productPrice = "$" + entry.getValue().toString().trim();
                } else { productStatus = false; }

                Assert.assertTrue(productStatus, productName +" Product not found on cart view page");
            }
            totalAmount = totalAmount + Double.parseDouble(this.pageCart.doGetText(this.pageCart.getShippingCost()).replace("$", ""));
            bigDecimal= new BigDecimal(totalAmount).setScale(2, RoundingMode.HALF_UP);
            amount= bigDecimal.doubleValue();
            softAssert.assertEquals("$" + String.valueOf(Double.parseDouble(this.pageCart.doGetText(this.pageCart.getTotalCost()).replace("$", ""))), "$" + String.valueOf(amount), "Total amount not matched");

            this.pageCart.clkBtnRemove(this.productName, this.productPrice);
            Thread.sleep(5000);
            if (this.pageCart.getProduct(this.productName, this.productPrice) == 0) {
                productStatus = true;
                totalAmount = totalAmount - Double.parseDouble(this.productPrice.replace("$", ""));
            } else {
                productStatus = false;
            }
            Assert.assertTrue(productStatus, productName+" Product not removed from cart view page");
            Thread.sleep(5000);
            softAssert.assertEquals(Integer.valueOf(this.pageCart.doGetText(this.pageCart.getCartProductCount())), Integer.valueOf(productInfo.size() - 1), "Product not get decrease");
            waitUtil.getWebDriverWait().until(ExpectedConditions.visibilityOf(this.pageCart.getTotalCost()));
            bigDecimal= new BigDecimal(totalAmount).setScale(2, RoundingMode.HALF_UP);
            amount = bigDecimal.doubleValue();
            softAssert.assertEquals("$" + String.valueOf(Double.parseDouble(this.pageCart.doGetText(this.pageCart.getTotalCost()).replace("$", ""))), "$" + String.valueOf(amount), "Amount not get desrease");

            softAssert.assertAll();
        }
    }
@DataProvider(name = "TestDataRemoveProduct")
public Object[][] passTestDataRemoveProduct(){
        Object [][]data=new Object[2][2];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        data[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        data[0][1]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        data[1][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),2);
        data[1][1]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),2);
        return data;
    }

@Test(enabled = true,groups = {"Sanity"},dataProvider = "TestDataVerifyCheckOut",priority = 8)
public void verifyCheckOut(String productName, String productPrice, Integer productID,ITestContext iTestContext) {
    SoftAssert softAssert = new SoftAssert();
    testReportUtil.configureTest("verify_CheckOut");
    if (this.pageHome.getProductAvailabilityStatus(productName, productPrice) == 1) {
        this.pageHome.clkAddToCart(productName, productPrice).click();
        this.pageProductCartView=new PageProductCartView(driver);
        productStatus = true;
        iTestContext.setAttribute("productID",productID);
    }else {productStatus=false;}
    Assert.assertTrue(productStatus, productName+" Product not found on home page");
    this.pageProductCartView.clkBtnCloseFromCartView();
    actionsHandleUtil.moveElement(this.pageHome.getLnkLblCart());
    this.pageCart = new PageCart(this.driver);
    iTestContext.setAttribute(productName,Integer.valueOf(this.pageCart.doGetText(this.pageCart.getCartProductQuantity(productName,productPrice))));
    iTestContext.setAttribute("productQuantity",Integer.valueOf(this.pageCart.doGetText(this.pageCart.getCartProductCount())));
    this.pageCart.clkBtnCheckOut();
    if (!this.driver.getCurrentUrl().contains("order")) {
        softAssert.assertTrue(false, "Checkout button not working");
    }
    softAssert.assertAll();
}
@DataProvider(name = "TestDataVerifyCheckOut")
public Object[][] passTestDataVerifyCheckOut(){
        Object [][]data=new Object[1][3];
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),getExcelPath(ExcelFilesPath.ProductInfoExcel).getExcelFilePath().toString().trim());
        data[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        data[0][1]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        data[0][2]=this.productInfoExcelUtil.getProductID(ExcelFilesNames.ProductInfoExcel.toString(),this.getSheetName(SheetNames.ProductInfoExcel_ProductList).getSheetName().trim(),1);
        return data;
    }

@AfterMethod(enabled = true,groups = {"Smoke","Sanity"})
public void setupAfterMethod(ITestResult testResult) {
    testReportUtil.configureTestResult(testResult);
}









}
