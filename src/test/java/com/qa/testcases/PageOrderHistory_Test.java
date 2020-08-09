package com.qa.testcases;

import com.qa.pages.PageOrderConfirmation;
import com.qa.pages.PageOrderHistory;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ColumnNames;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PageOrderHistory_Test extends TestBase {

    PageOrderHistory pageOrderHistory;
    ProductInfoExcelUtil productInfoExcelUtil;
    SheetNames sheetNames;
    SimpleDateFormat simpleDateFormat;
    Date date;
    String currentDate;
    Map<String,String> storeProductHistory;
    ColumnNames columnNames;


    @BeforeClass(groups = {"Sanity"})
    public void setupBeforeClass(){
        this.pageOrderHistory=new PageOrderHistory(driver);
        this.productInfoExcelUtil=new ProductInfoExcelUtil(ExcelFilesNames.ProductInfoExcel.toString(),"./testdata/ProductData.xlsx");
        this.simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
        this.date=new Date();
        currentDate=this.simpleDateFormat.format(this.date);
    }

    @BeforeMethod
    public void setupBeforeMethod(){

    }

    @Test(groups = {"Sanity"},priority = 46)
    public void TC01(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        this.sheetNames=SheetNames.ProductInfoExcel_ProductList;
        System.out.println("Page is " +this.pageOrderHistory);
        System.out.println("get date "+this.pageOrderHistory.getDate(iTestContext.getAttribute("referenceNumber").toString()));
        System.out.println("Crrent date " +this.currentDate);
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getDate(iTestContext.getAttribute("referenceNumber").toString())),this.currentDate);
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getTotalPrice(iTestContext.getAttribute("referenceNumber").toString().trim())),"$"+String.valueOf(Double.parseDouble(this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),Integer.valueOf(iTestContext.getAttribute("productID").toString())).replace("$",""))+new Double("2.00")));
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getStatus(iTestContext.getAttribute("referenceNumber").toString().trim())),"On backorder");
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 47)
    public void TC02(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        this.pageOrderHistory.clkBtnExpandOrder(iTestContext.getAttribute("referenceNumber").toString());
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getPaymentType(iTestContext.getAttribute("referenceNumber").toString())).trim(),iTestContext.getAttribute("paymentType").toString().trim());
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 48,enabled = false)
    public void TC03(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        this.pageOrderHistory.clkBtnReOrder(iTestContext.getAttribute("referenceNumber").toString());
        softAssert.assertEquals(driver.getCurrentUrl().contains("order"),true);
        softAssert.assertAll();
        driver.navigate().back();

    }



    @Test(groups = {"Sanity"},priority = 49)
    public void TC04(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        this.pageOrderHistory.clkBtnExpandOrder(iTestContext.getAttribute("referenceNumber").toString());
        this.pageOrderHistory.clkBtnDetails(iTestContext.getAttribute("referenceNumber").toString());
        actionsHandleUtil.moveElement(this.pageOrderHistory.getLblFollowYourOrderStatusStepByStep());
        softAssert.assertEquals(this.pageOrderHistory.getLblFollowYourOrderStatusStepByStep().isDisplayed(),true);
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 50)
    public void TC05(ITestContext iTestContext) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(this.pageOrderHistory.getOrderReference().trim(), iTestContext.getAttribute("referenceNumber").toString());
        softAssert.assertEquals(this.pageOrderHistory.getOrderPlacedDate(),this.currentDate);
        softAssert.assertEquals(this.pageOrderHistory.getCarrierName().trim()," My carrier".trim());
        softAssert.assertEquals(this.pageOrderHistory.getPaymentMethod().trim(),iTestContext.getAttribute("paymentType").toString());
        softAssert.assertAll();
    }

    @Test(groups = {"Sanity"},priority = 51)
    public void TC06(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pageOrderHistory.getBackOrderDate(),this.currentDate);
        softAssert.assertEquals(this.pageOrderHistory.getAwaitingBankWirePaymentDate(),this.currentDate);
        softAssert.assertEquals(this.pageOrderHistory.getBackOrderStatus().trim(),"On backorder".trim());
        softAssert.assertEquals(this.pageOrderHistory.getAwaitingBankWirePaymentStatus().trim(),"Awaiting bank wire payment".trim());
        softAssert.assertAll();

    }


    @Test(groups = {"Sanity"},priority = 52,dataProvider = "Data")
    public void TC07(String firstName,String lastName,String companyName,String address,String addressLineTwo,String city,String State,Integer postalNo,String CountryName,Integer homeNumber,Long mobileNumber,ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pageOrderHistory.getFirstNameFromDA().trim(),firstName);
        softAssert.assertEquals(this.pageOrderHistory.getLastNameFromDA().trim(),lastName);
        softAssert.assertEquals(this.pageOrderHistory.getCompanyNameFromDA().trim(),companyName);
        softAssert.assertEquals(this.pageOrderHistory.getAddressFromDA().trim(),address);
        softAssert.assertEquals(this.pageOrderHistory.getAddressLineTwoFromDA().trim(),addressLineTwo);
        softAssert.assertEquals(this.pageOrderHistory.getCityFromDA().trim(),city);
        softAssert.assertEquals(this.pageOrderHistory.getStateFromDA().trim(),State);
        softAssert.assertEquals(Integer.valueOf(this.pageOrderHistory.getPostalNoFromDA()),postalNo);
        softAssert.assertEquals(this.pageOrderHistory.getCountryNameFromDA().trim(),CountryName);
        softAssert.assertEquals(Integer.valueOf(this.pageOrderHistory.getHomeNumberFromDA()),homeNumber);
        softAssert.assertEquals(Long.valueOf(this.pageOrderHistory.getMobileNumberFromDA().trim()),mobileNumber);
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

    @Test(groups = {"Sanity"},enabled = true,dataProvider = "DataTwo",priority = 53)
    public void TC08(String firstName,String lastName,String companyName,String address,String addressLineTwo,String city,String State,Integer postalNo,String CountryName,Integer homeNumber,Long mobileNumber){
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(this.pageOrderHistory.getFirstNameFromBA().trim(),firstName);
        softAssert.assertEquals(this.pageOrderHistory.getLastNameFromBA().trim(),lastName);
        softAssert.assertEquals(this.pageOrderHistory.getCompanyNameFromBA().trim(),companyName);
        softAssert.assertEquals(this.pageOrderHistory.getAddressFromBA().trim(),address);
        softAssert.assertEquals(this.pageOrderHistory.getAddressLineTwoFromBA().trim().replace(".",""),addressLineTwo);
        softAssert.assertEquals(this.pageOrderHistory.getCityFromBA().trim(),city);
        softAssert.assertEquals(this.pageOrderHistory.getStateFromBA().trim(),State);
        softAssert.assertEquals(Integer.valueOf(this.pageOrderHistory.getPostalNoFromBA()),postalNo);
        softAssert.assertEquals(this.pageOrderHistory.getCountryNameFromBA().trim(),CountryName);
        softAssert.assertEquals(Integer.valueOf(this.pageOrderHistory.getHomeNumberFromBA()),homeNumber);
        softAssert.assertEquals(Long.valueOf(this.pageOrderHistory.getMobileNumberFromBA().trim()),mobileNumber);
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

    @Test(groups = {"Sanity"},priority = 54,dataProvider = "DataThree")
    public void TC09(String productName,String productColor,String productSize,String productPrice,ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getReference()),"demo_1");
        softAssert.assertEquals(this.pageOrderHistory.getProductNAME().trim(),productName.trim());
        softAssert.assertEquals(this.pageOrderHistory.getProductColor().trim(),productColor.trim());
        softAssert.assertEquals(this.pageOrderHistory.getProductSize().trim(),productSize.trim());
        softAssert.assertEquals(Integer.valueOf(this.pageOrderHistory.doGetText(this.pageOrderHistory.getProductQuantity())),Integer.valueOf(iTestContext.getAttribute("productQuantity").toString()));
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getUnitPrice()),productPrice);
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getTotalPrice()),"$"+String.valueOf(Double.parseDouble(this.pageOrderHistory.doGetText(this.pageOrderHistory.getProductQuantity()))*Double.parseDouble(this.pageOrderHistory.doGetText(this.pageOrderHistory.getUnitPrice()).replace("$",""))));
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getItemTaxExclude()),"$16.51");
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getItemTaxInclude()),"$16.51");
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getShippingAndHandingTaxInclude()),"$2.00");
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getTotal()),"$"+String.valueOf(Double.parseDouble(this.pageOrderHistory.doGetText(this.pageOrderHistory.getUnitPrice()).replace("$",""))+Double.parseDouble(this.pageOrderHistory.doGetText(this.pageOrderHistory.getShippingAndHandingTaxInclude()).replace("$",""))));

        softAssert.assertAll();
    }

    @DataProvider(name = "DataThree")
    public Object[][] getDataThree(){
        this.sheetNames=SheetNames.ProductInfoExcel_ProductList;
        Object[][] data=new Object[1][4];
        data[0][0]=this.productInfoExcelUtil.getProductName(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),1);
        data[0][1]=this.productInfoExcelUtil.getProductColor(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),1);
        data[0][2]=this.productInfoExcelUtil.getProductSize(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),1);
        data[0][3]=this.productInfoExcelUtil.getProductPrice(ExcelFilesNames.ProductInfoExcel.toString(),sheetNames.getSheetName(),1);
        return data;
    }

    @Test(groups = {"Sanity"},priority = 55)
    public void TC10(ITestContext iTestContext){
        SoftAssert softAssert=new SoftAssert();
        this.sheetNames=SheetNames.ProductInfoExcel_UserDetails;
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getShippingCost()),"$2.00");
        this.pageOrderHistory.selectProduct(this.pageOrderHistory.doGetText(this.pageOrderHistory.ProductName()).trim());
        this.pageOrderHistory.passMessage("This is my first order");
        this.pageOrderHistory.clkBtnSend();
        softAssert.assertEquals(this.pageOrderHistory.getMsgSuccessfullySent().isDisplayed(),true);
        softAssert.assertEquals(this.pageOrderHistory.getUserName(),iTestContext.getAttribute("UserName"));
        softAssert.assertEquals(this.pageOrderHistory.getDate(),this.currentDate);
        softAssert.assertEquals(this.pageOrderHistory.doGetText(this.pageOrderHistory.getMessage()).trim(),"This is my first order".trim());
        softAssert.assertAll();

    }

    @Test(groups = {"Sanity"},priority = 56)
    public void TC11(ITestContext iTestContext){
        this.storeProductHistory=new HashMap<String,String>();

        this.storeProductHistory.put(this.getColumnName(ColumnNames.OrderHistory_ReferenceNumber).getColumnName().trim(),iTestContext.getAttribute("referenceNumber").toString().trim());
       System.out.println(this.getColumnName(ColumnNames.OrderHistory_ReferenceNumber).getColumnName().trim());



       this.storeProductHistory.put(this.getColumnName(ColumnNames.OrderHistory_OrderDate).getColumnName().trim(),this.pageOrderHistory.getBackOrderDate());
        this.storeProductHistory.put(this.getColumnName(ColumnNames.OrderHistory_ProductName).getColumnName().trim(),this.pageOrderHistory.getProductNAME().toString().trim());
        this.storeProductHistory.put(this.getColumnName(ColumnNames.OrderHistory_ProductQuantity).getColumnName().trim(),this.pageOrderHistory.doGetText(this.pageOrderHistory.getProductQuantity()));
        this.storeProductHistory.put(this.getColumnName(ColumnNames.OrderHistory_UnitPrice).getColumnName().trim(),this.pageOrderHistory.doGetText(this.pageOrderHistory.getUnitPrice()));
        this.storeProductHistory.put(this.getColumnName(ColumnNames.OrderHistory_TotalPrice).getColumnName().trim(),this.pageOrderHistory.doGetText(this.pageOrderHistory.getTotal()));
        this.storeProductHistory.put(this.getColumnName(ColumnNames.OrderHistory_PaymentMethod).getColumnName().trim(),this.pageOrderHistory.getAwaitingBankWirePaymentStatus().trim());
        this.sheetNames= SheetNames.ProductInfoExcel_OrderHistory;
        this.productInfoExcelUtil.storeProductHistory(ExcelFilesNames.ProductInfoExcel.toString(),this.sheetNames.getSheetName(),this.storeProductHistory);

        this.productInfoExcelUtil.writeData(ExcelFilesNames.ProductInfoExcel.toString(),"./testdata/ProductData.xlsx");

        this.productInfoExcelUtil.closeFile();










    }













    @AfterMethod
    public void setupAfterMethod(){

    }

    @AfterClass
    public void setupAfterClass(){

    }














}
