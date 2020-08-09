package com.qa.pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PageOrderHistory extends PageBase{

    WebDriver driver;
    public PageOrderHistory(WebDriver driver) {
        super(driver);
        try{ this.driver=driver;
            PageFactory.initElements(this.driver,this);
        }catch (Exception ae){
            ae.printStackTrace(); }
    }

    public WebElement getBtnExpandOrder(String orderReference) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/preceding-sibling::span[1]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/preceding-sibling::span[1]"));
        } else { return null; }
    }
    public void clkBtnExpandOrder(String orderReference) throws TimeoutException,NullPointerException{
        doClick(getBtnExpandOrder(orderReference));
    }


    public WebElement getDate(String orderReference) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::td[1]/following-sibling::td[1]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::td[1]/following-sibling::td[1]")); } else { return null; }
    }


    public WebElement getTotalPrice(String orderReference) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::td[1]/following-sibling::td[2]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::td[1]/following-sibling::td[2]")); } else { return null; }
    }


    public WebElement getStatus(String orderReference) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::td[1]/following-sibling::td[4]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::td[1]/following-sibling::td[4]")); } else { return null; }
    }


    public WebElement getPaymentType(String orderReference) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::tr[1]/following-sibling::tr/descendant::div[contains(text(),'Payment:')]/following-sibling::div[1]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::tr[1]/following-sibling::tr/descendant::div[contains(text(),'Payment:')]/following-sibling::div[1]")); } else { return null; }
    }

    public WebElement getBtnDetails(String orderReference) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::tr[1]/following-sibling::tr[1]/descendant::span[1]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::tr[1]/following-sibling::tr[1]/descendant::span[1]"));
        } else { return null; }
    }
    public void clkBtnDetails(String orderReference) throws TimeoutException,NullPointerException{
        doClick(getBtnDetails(orderReference));
    }

    public WebElement getBtnReOrder(String orderReference) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::tr[1]/following-sibling::tr[1]/descendant::a[contains(@title,'Reorder')]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//table[contains(@id,'order-list')]/descendant::a[contains(@class,'color-myaccount')][contains(text(),'"+orderReference+"')]/ancestor::tr[1]/following-sibling::tr[1]/descendant::a[contains(@title,'Reorder')]"));
        } else { return null; }
    }
    public void clkBtnReOrder(String orderReference) throws TimeoutException,NullPointerException{
        doClick(getBtnReOrder(orderReference));
    }


    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Order history')]/ancestor::div[1]/descendant::div[1]/following-sibling::ul/descendant::span[1]")
    private WebElement btnBackToYourAccount;
    public WebElement getBtnBackToYourAccount() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h1[contains(text(),'Order history')]/ancestor::div[1]/descendant::div[1]/following-sibling::ul/descendant::span[1]", Locator.XPath)) {
            return this.btnBackToYourAccount; } else { return null; } }

    public void clkBtnBackToYourAccount()throws TimeoutException,NullPointerException {
        doClick(getBtnBackToYourAccount());
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Order history')]/ancestor::div[1]/descendant::div[1]/following-sibling::ul/descendant::span[2]")
    private WebElement btnHome;
    public WebElement getBtnHome() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h1[contains(text(),'Order history')]/ancestor::div[1]/descendant::div[1]/following-sibling::ul/descendant::span[2]", Locator.XPath)) {
            return this.btnHome; } else { return null; } }

    public void clkBtnHome()throws TimeoutException,NullPointerException {
        doClick(getBtnHome());
    }

   //=========================================Details page==========================================================


    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Reorder')]/ancestor::a[1]/following-sibling::p/descendant::strong[1]")
    private WebElement orderReferenceAndOrderPlacedDate;

    public String getOrderReference(){
        return  this.doGetText(this.orderReferenceAndOrderPlacedDate).split("--")[0].split(" ")[2];
    }

    public String getOrderPlacedDate(){
        return this.doGetText(this.orderReferenceAndOrderPlacedDate).split("--")[1].split(" ")[3];
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'block-order-detail')]/descendant::span[1]")
    private WebElement btnReorder;
    public WebElement getBtnReOrder() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'block-order-detail')]/descendant::span[1]", Locator.XPath)) {
            return this.btnReorder; } else { return null; }
    }

    public void clkBtnReorder()throws TimeoutException,NullPointerException {
        doClick(getBtnReOrder());
    }

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Carrier')]/ancestor::p[1]")
    private WebElement carrier;
    public WebElement Carrier() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'block-order-detail')]/descendant::p[2]", Locator.XPath)) {
            return this.carrier; } else { return null; }
    }

    public String getCarrierName(){
        String carrierName=" ";
        String []Temp=this.doGetText(this.Carrier()).split(" ");
        for(int i=0;i<Temp.length;i++){
            if(i!=0){
                carrierName=carrierName+" "+Temp[i];
            }
        }return carrierName.trim();
    }



    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Payment method')]/ancestor::p[1]")
    private WebElement paymentMethod;
    public WebElement PaymentMethod() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//strong[contains(text(),'Payment method')]/ancestor::p[1]", Locator.XPath)) {
            return this.paymentMethod; } else { return null; }
    }

    public String getPaymentMethod(){
        String paymentMethod=" ";
        String []Temp=this.doGetText(this.PaymentMethod()).split(" ");
        for(int i=0;i<Temp.length;i++){
            if(i!=0 && i!=1){
                paymentMethod=paymentMethod+" "+Temp[i];
            }
        }return paymentMethod.trim();
    }



    @FindBys(@FindBy(how=How.XPATH, using = "//div[contains(@id,'block-order-detail')]/descendant::table[starts-with(@class,'detail_step')]/descendant::tr/th"))
    List<WebElement> tableHeaders;
    private List<WebElement> getTableHeaders(){
        if (verifyPresentOfElement("//div[contains(@id,'block-order-detail')]/descendant::table[starts-with(@class,'detail_step')]/descendant::tr/th", Locator.XPath)) {
            return this.tableHeaders; } else { return null; }
    }


    public String getBackOrderDate(){
        String backOrderDate="";
        Integer length=getTableHeaders().size();
        for(int i=0;i<length;i++){
            if(getTableHeaders().get(i).getText().trim().equals("Date")){
                backOrderDate=driver.findElement(By.xpath("//div[contains(@id,'block-order-detail')]/descendant::table[starts-with(@class,'detail_step')]/descendant::tr[2]/td["+String.valueOf((i+1))+"]")).getText().trim();
            }
        }return backOrderDate;

    }

    public String getAwaitingBankWirePaymentDate(){
        String AwaitingBankWirePaymentDate="";
        Integer length=getTableHeaders().size();
        for(int i=0;i<length;i++){
            if(getTableHeaders().get(i).getText().trim().equals("Date")){
                AwaitingBankWirePaymentDate=driver.findElement(By.xpath("//div[contains(@id,'block-order-detail')]/descendant::table[starts-with(@class,'detail_step')]/descendant::tr[3]/td["+String.valueOf((i+1))+"]")).getText().trim();
            }
        }return AwaitingBankWirePaymentDate;

    }



    public String getBackOrderStatus(){
        String backOrderStatus="";
        Integer length=getTableHeaders().size();
        for(int i=0;i<length;i++){
            if(getTableHeaders().get(i).getText().trim().equals("Status")){
                backOrderStatus=driver.findElement(By.xpath("//div[contains(@id,'block-order-detail')]/descendant::table[starts-with(@class,'detail_step')]/descendant::tr[2]/td["+String.valueOf((i+1))+"]")).getText().trim();
            }
        }return backOrderStatus;

    }

    public String getAwaitingBankWirePaymentStatus(){
        String AwaitingBankWirePaymentStatus="";
        Integer length=getTableHeaders().size();
        for(int i=0;i<length;i++){
            if(getTableHeaders().get(i).getText().trim().equals("Status")){
                AwaitingBankWirePaymentStatus=driver.findElement(By.xpath("//div[contains(@id,'block-order-detail')]/descendant::table[starts-with(@class,'detail_step')]/descendant::tr[3]/td["+String.valueOf((i+1))+"]")).getText().trim();
            }
        }return AwaitingBankWirePaymentStatus;

    }

//===================================Biling address===========================================================

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address item  box')]/li[2]")
    private WebElement FirstNameAndLastNameFromBA;
    private WebElement getFirstNameAndLastNameFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address item  box')]/li[2]", Locator.XPath)) {
            return this.FirstNameAndLastNameFromBA; } else { return null; }
    }
    public String getFirstNameFromBA(){
        return doGetText(this.getFirstNameAndLastNameFromBA()).split(" ")[0].trim();
    }
    public String getLastNameFromBA(){
        return doGetText(this.getFirstNameAndLastNameFromBA()).split(" ")[1].trim();
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address item  box')]/li[3]")
    private WebElement companyNameFromBA;
    private WebElement getcompanyNameFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address item  box')]/li[3]", Locator.XPath)) {
            return this.companyNameFromBA; } else { return null; }
    }
    public String getCompanyNameFromBA(){
        return this.doGetText(getcompanyNameFromBA());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address item  box')]/li[4]")
    private WebElement AddressAndAddressLineTwoFromBA;
    private WebElement getAddressAndAddressLineTwoFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address item  box')]/li[4]", Locator.XPath)) {
            return this.AddressAndAddressLineTwoFromBA; } else { return null; }
    }
    public String getAddressFromBA(){
        return doGetText(this.getAddressAndAddressLineTwoFromBA()).split(" ")[0].trim();
    }
    public String getAddressLineTwoFromBA(){
        return doGetText(this.getAddressAndAddressLineTwoFromBA()).split(" ")[1].trim()+" "+doGetText(this.getAddressAndAddressLineTwoFromBA()).split(" ")[2].trim();
    }


    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address item  box')]/li[5]")
    private WebElement CityAndStateAndPinFromBA;
    private WebElement getCityAndStateAndPinFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address item  box')]/li[5]", Locator.XPath)) {
            return this.CityAndStateAndPinFromBA; } else { return null; }
    }
    public String getCityFromBA(){
        return doGetText(this.getCityAndStateAndPinFromBA()).split(" ")[0].trim();
    }
    public String getStateFromBA(){
        return doGetText(this.getCityAndStateAndPinFromBA()).split(" ")[1].trim();
    }
    public String getPostalNoFromBA(){
        return doGetText(this.getCityAndStateAndPinFromBA()).split(" ")[2].trim();
    }


    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address item  box')]/li[6]")
    private WebElement countryNameFromBA;
    private WebElement getcountryNameFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address item  box')]/li[6]", Locator.XPath)) {
            return this.countryNameFromBA; } else { return null; }
    }
    public String getCountryNameFromBA(){
        return this.doGetText(getcountryNameFromBA());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address item  box')]/li[7]")
    private WebElement homeNumberFromBA;
    private WebElement gethomeNumberFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address item  box')]/li[7]", Locator.XPath)) {
            return this.homeNumberFromBA; } else { return null; }
    }
    public String getHomeNumberFromBA(){
        return this.doGetText(gethomeNumberFromBA());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address item  box')]/li[8]")
    private WebElement mobilenumberFromBA;
    private WebElement getmobilenumberFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address item  box')]/li[8]", Locator.XPath)) {
            return this.mobilenumberFromBA; } else { return null; }
    }
    public String getMobileNumberFromBA(){
        return this.doGetText(getmobilenumberFromBA());
    }

    //==============================================================================================================

    //=================================================Dilevery Address=================================================

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address alternate_item box')]/li[2]")
    private WebElement FirstNameAndLastName;
    private WebElement getFirstNameAndLastName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address alternate_item box')]/li[2]", Locator.XPath)) {
            return this.FirstNameAndLastName; } else { return null; }
    }
    public String getFirstNameFromDA(){
        return doGetText(this.getFirstNameAndLastName()).split(" ")[0].trim();
    }
    public String getLastNameFromDA(){
        return doGetText(this.getFirstNameAndLastName()).split(" ")[1].trim();
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address alternate_item box')]/li[3]")
    private WebElement companyName;
    private WebElement getcompanyName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address alternate_item box')]/li[3]", Locator.XPath)) {
            return this.companyName; } else { return null; }
    }
    public String getCompanyNameFromDA(){
        return this.doGetText(getcompanyName());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address alternate_item box')]/li[4]")
    private WebElement AddressAndAddressLineTwo;
    private WebElement getAddressAndAddressLineTwo() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address alternate_item box')]/li[4]", Locator.XPath)) {
            return this.AddressAndAddressLineTwo; } else { return null; }
    }
    public String getAddressFromDA(){
        return doGetText(this.getAddressAndAddressLineTwo()).split(" ")[0].trim();
    }
    public String getAddressLineTwoFromDA(){
        return doGetText(this.getAddressAndAddressLineTwo()).split(" ")[1].trim()+" "+doGetText(this.getAddressAndAddressLineTwo()).split(" ")[2].trim();
    }


    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address alternate_item box')]/li[5]")
    private WebElement CityAndStateAndPin;
    private WebElement getCityAndStateAndPin() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address alternate_item box')]/li[5]", Locator.XPath)) {
            return this.CityAndStateAndPin; } else { return null; }
    }
    public String getCityFromDA(){
        return doGetText(this.getCityAndStateAndPin()).split(" ")[0].trim();
    }
    public String getStateFromDA(){
        return doGetText(this.getCityAndStateAndPin()).split(" ")[1].trim();
    }
    public String getPostalNoFromDA(){
        return doGetText(this.getCityAndStateAndPin()).split(" ")[2].trim();
    }


    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address alternate_item box')]/li[6]")
    private WebElement countryName;
    private WebElement getcountryName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address alternate_item box')]/li[6]", Locator.XPath)) {
            return this.countryName; } else { return null; }
    }
    public String getCountryNameFromDA(){
        return this.doGetText(getcountryName());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address alternate_item box')]/li[7]")
    private WebElement homeNumber;
    private WebElement gethomeNumber() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address alternate_item box')]/li[7]", Locator.XPath)) {
            return this.homeNumber; } else { return null; }
    }
    public String getHomeNumberFromDA(){
        return this.doGetText(gethomeNumber());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'address alternate_item box')]/li[8]")
    private WebElement mobilenumber;
    private WebElement getmobilenumber() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@class,'address alternate_item box')]/li[8]", Locator.XPath)) {
            return this.mobilenumber; } else { return null; }
    }
    public String getMobileNumberFromDA(){
        return this.doGetText(getmobilenumber());
    }

    //==============================================================================================












    //Delivery address.

    @FindBys(@FindBy(how=How.XPATH, using = "//h3[contains(text(),'Delivery address (Test)')]/ancestor::ul[1]/descendant::li[1]/following-sibling::li"))
    List<WebElement> deliveryAddress;
    private List<WebElement> getdeliveryAddress(){
        if (verifyPresentOfElement("//h3[contains(text(),'Delivery address (Test)')]/ancestor::ul[1]/descendant::li[1]/following-sibling::li", Locator.XPath)) {
            return this.deliveryAddress; } else { return null; }
    }

    public ArrayList<String> getDeliveryAddress(){
        ArrayList<String>deliveryAddress=new ArrayList<>();
        for (int i=0;i<getDeliveryAddress().size();i++){
            if(!this.doGetText(getdeliveryAddress().get(i)).equals(""))
            deliveryAddress.add(this.doGetText(getdeliveryAddress().get(i)));
        }return deliveryAddress;
    }

    @FindBys(@FindBy(how=How.XPATH, using = "//h3[contains(text(),'Invoice address (Test)')]/ancestor::ul[1]/descendant::li[1]/following-sibling::li"))
    List<WebElement> invoiceAddress;
    private List<WebElement> getinvoiceAddress(){
        if (verifyPresentOfElement("//h3[contains(text(),'Invoice address (Test)')]/ancestor::ul[1]/descendant::li[1]/following-sibling::li", Locator.XPath)) {
            return this.invoiceAddress; } else { return null; }
    }

    public ArrayList<String> getInvoiceAddress(){
        ArrayList<String>invoiceAddress=new ArrayList<>();
        for (int i=0;i<getDeliveryAddress().size();i++){
            if(!this.doGetText(getdeliveryAddress().get(i)).equals(""))
                invoiceAddress.add(this.doGetText(getdeliveryAddress().get(i)));
        }return invoiceAddress;
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'block-order-detail')]/descendant::h1[1]")
    private WebElement lblFollowYourOrderStatusStepByStep;
    public WebElement getLblFollowYourOrderStatusStepByStep() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'block-order-detail')]/descendant::h1[1]", Locator.XPath)) {
            return this.lblFollowYourOrderStatusStepByStep; } else { return null; }
    }





    //Product details..............................

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'order-detail-content')]/descendant::label[1]")
    private WebElement reference;
    public WebElement getReference() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'order-detail-content')]/descendant::label[1]", Locator.XPath)) {
            return this.reference; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'order-detail-content')]/descendant::label[2]")
    private WebElement productName;
    public WebElement ProductName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'order-detail-content')]/descendant::label[2]", Locator.XPath)) {
            return this.productName; } else { return null; }
    }

    public String getProductNAME(){
       return doGetText(this.ProductName()).substring(0,doGetText(this.ProductName()).lastIndexOf("-"));
    }

    public String getProductColor(){
       return doGetText(this.ProductName()).substring((doGetText(this.ProductName()).indexOf("-")+1),doGetText(this.ProductName()).length()).split(",")[0].split(":")[1].trim();
    }

    public String getProductSize(){
        return doGetText(this.ProductName()).substring((doGetText(this.ProductName()).indexOf("-")+1),doGetText(this.ProductName()).length()).split(",")[1].split(":")[1].trim();
    }


    @FindBy(how = How.XPATH, using = "//div[contains(@id,'order-detail-content')]/descendant::label[3]")
    private WebElement productQuantity;
    public WebElement getProductQuantity() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'order-detail-content')]/descendant::label[3]", Locator.XPath)) {
            return this.productQuantity; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'order-detail-content')]/descendant::label[4]")
    private WebElement unitPrice;
    public WebElement getUnitPrice() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'order-detail-content')]/descendant::label[4]", Locator.XPath)) {
            return this.unitPrice; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'order-detail-content')]/descendant::label[5]")
    private WebElement totalPrice;
    public WebElement getTotalPrice() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'order-detail-content')]/descendant::label[5]", Locator.XPath)) {
            return this.totalPrice; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'order-detail-content')]/descendant::span[2]")
    private WebElement itemTaxInclude;
    public WebElement getItemTaxInclude() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'order-detail-content')]/descendant::span[2]", Locator.XPath)) {
            return this.itemTaxInclude; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'order-detail-content')]/descendant::span[1]")
    private WebElement itemTaxExclude;
    public WebElement getItemTaxExclude() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'order-detail-content')]/descendant::span[1]", Locator.XPath)) {
            return this.itemTaxExclude; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'order-detail-content')]/descendant::span[3]")
    private WebElement shippingAndHandingTaxInclude;
    public WebElement getShippingAndHandingTaxInclude() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'order-detail-content')]/descendant::span[3]", Locator.XPath)) {
            return this.shippingAndHandingTaxInclude; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'order-detail-content')]/descendant::span[4]")
    private WebElement total;
    public WebElement getTotal() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'order-detail-content')]/descendant::span[4]", Locator.XPath)) {
            return this.total; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'order-detail-content')]/ancestor::form/following-sibling::table/descendant::td[4]")
    private WebElement shippingCost;
    public WebElement getShippingCost() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'order-detail-content')]/ancestor::form/following-sibling::table/descendant::td[4]", Locator.XPath)) {
            return this.shippingCost; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//select[contains(@name,'id_product')]")
    private WebElement ddProduct;
    public WebElement getDDProduct() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//select[contains(@name,'id_product')]", Locator.XPath)) {
            return this.ddProduct; } else { return null; }
    }
    public void selectProduct(String product){
        this.dropdownHandleUtil.selectValue(getDDProduct(),product);
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'submitMessage')]/ancestor::div[1]/preceding-sibling::p[1]/textarea[1]")
    private WebElement txtMessage;
    public WebElement getTxtMessage() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@name,'submitMessage')]/ancestor::div[1]/preceding-sibling::p[1]/textarea[1]", Locator.XPath)) {
            return this.txtMessage; } else { return null; }
    }

    public void passMessage(String message){
        this.doSendKeys(getTxtMessage(),message);
    }

    @FindBy(how = How.XPATH, using = "//button[contains(@name,'submitMessage')]")
    private WebElement btnSend;
    public WebElement getBtnSend() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@name,'submitMessage')]", Locator.XPath)) {
            return this.btnSend; } else { return null; }
    }

    public void clkBtnSend(){
        doClick(getBtnSend());
    }

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Message successfully sent')]")
    private WebElement msgSuccessfullySent;
    public WebElement getMsgSuccessfullySent() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//p[contains(text(),'Message successfully sent')]", Locator.XPath)) {
            return this.msgSuccessfullySent; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//th[contains(text(),'From')]/ancestor::table/descendant::td[1]")
    private WebElement from;
    private WebElement getFrom() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//th[contains(text(),'From')]/ancestor::table/descendant::td[1]", Locator.XPath)) {
            return this.from; } else { return null; }
    }

    public String getUserName(){
        return doGetText(this.getFrom()).split(" ")[0]+" "+doGetText(this.getFrom()).split(" ")[1].split("\n")[0];
    }

    public String getDate(){
        return doGetText(this.getFrom()).split("\n")[1].split(" ")[0];
    }

    @FindBy(how = How.XPATH, using = "//th[contains(text(),'From')]/ancestor::table/descendant::td[2]")
    private WebElement message;
    public WebElement getMessage() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//th[contains(text(),'From')]/ancestor::table/descendant::td[2]", Locator.XPath)) {
            return this.message;
        } else {
            return null;
        }
    }}























































































































