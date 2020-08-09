package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PageAddress extends PageBase {

    public WebDriver driver;
    public PageAddress(WebDriver webDriver){
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Addresses')]")
    private WebElement lblAddress;
    public WebElement getLblAddress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(text(),'Addresses')]", Locator.XPath)) {
            return this.lblAddress; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//select[contains(@name,'id_address_delivery')]")
    private WebElement ddDeliveryAddress;
    public WebElement getDDDeliveryAddress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//select[contains(@name,'id_address_delivery')]", Locator.XPath)) {
            return this.ddDeliveryAddress; } else { return null; }
    }
    public void clkDDDeliveryAddress()throws TimeoutException,NullPointerException {
        doClick(getDDDeliveryAddress());
    }





    @FindBy(how = How.XPATH, using = "//select[contains(@id,'id_address_invoice')]")
    private WebElement ddBillingAddress;
    public WebElement getDDBillingAddress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//select[contains(@id,'id_address_invoice')]", Locator.XPath)) {
            return this.ddBillingAddress; } else { return null; }
    }
    public void clkDDBillingAddress()throws TimeoutException,NullPointerException {
        doClick(getDDBillingAddress());
    }

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Choose a billing address:')]")
    private WebElement lblBillingAddress;
    public WebElement getLblBillingAddress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//label[contains(text(),'Choose a billing address:')]", Locator.XPath)) {
            return this.lblBillingAddress; } else { return null; }
    }







    @FindBy(how = How.XPATH, using = "//input[contains(@id,'addressesAreEquals')]")
    private WebElement chkDeliveryAddress;
    public WebElement getChkDeliveryAddress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@id,'addressesAreEquals')]", Locator.XPath)) {
            return this.chkDeliveryAddress; } else { return null; }
    }
    public void clkChkDeliveryAddress()throws TimeoutException,NullPointerException {
        doClick(getChkDeliveryAddress());
    }

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Choose a delivery address:')]/ancestor::div[3]/descendant::span[contains(text(),'Add a new address')]")
    private WebElement btnAddNewAddress;
    public WebElement getBtnAddNewAddress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//label[contains(text(),'Choose a delivery address:')]/ancestor::div[3]/descendant::span[contains(text(),'Add a new address')]", Locator.XPath)) {
            return this.btnAddNewAddress; } else { return null; }
    }
    public void clkBtnAddNewAddress()throws TimeoutException,NullPointerException {
        doClick(getBtnAddNewAddress());
    }

    //=============================================================================================================

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_delivery')]/li[2]")
    private WebElement FirstNameAndLastName;
    private WebElement getFirstNameAndLastName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_delivery')]/li[2]", Locator.XPath)) {
            return this.FirstNameAndLastName; } else { return null; }
    }
    public String getFirstNameFromDA(){
        return doGetText(this.getFirstNameAndLastName()).split(" ")[0].trim();
    }
    public String getLastNameFromDA(){
        return doGetText(this.getFirstNameAndLastName()).split(" ")[1].trim();
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_delivery')]/li[3]")
    private WebElement companyName;
    private WebElement getcompanyName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_delivery')]/li[3]", Locator.XPath)) {
            return this.companyName; } else { return null; }
    }
    public String getCompanyNameFromDA(){
        return this.doGetText(getcompanyName());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_delivery')]/li[4]")
    private WebElement AddressAndAddressLineTwo;
    private WebElement getAddressAndAddressLineTwo() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_delivery')]/li[4]", Locator.XPath)) {
            return this.AddressAndAddressLineTwo; } else { return null; }
    }
    public String getAddressFromDA(){
        return doGetText(this.getAddressAndAddressLineTwo()).split(" ")[0].trim();
    }
    public String getAddressLineTwoFromDA(){
        return doGetText(this.getAddressAndAddressLineTwo()).split(" ")[1].trim()+" "+doGetText(this.getAddressAndAddressLineTwo()).split(" ")[2].trim();
    }


    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_delivery')]/li[5]")
    private WebElement CityAndStateAndPin;
    private WebElement getCityAndStateAndPin() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_delivery')]/li[5]", Locator.XPath)) {
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


    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_delivery')]/li[6]")
    private WebElement countryName;
    private WebElement getcountryName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_delivery')]/li[6]", Locator.XPath)) {
            return this.countryName; } else { return null; }
    }
    public String getCountryNameFromDA(){
        return this.doGetText(getcountryName());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_delivery')]/li[7]")
    private WebElement homeNumber;
    private WebElement gethomeNumber() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_delivery')]/li[7]", Locator.XPath)) {
            return this.homeNumber; } else { return null; }
    }
    public String getHomeNumberFromDA(){
        return this.doGetText(gethomeNumber());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_delivery')]/li[8]")
    private WebElement mobilenumber;
    private WebElement getmobilenumber() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_delivery')]/li[8]", Locator.XPath)) {
            return this.mobilenumber; } else { return null; }
    }
    public String getMobileNumberFromDA(){
        return this.doGetText(getmobilenumber());
    }

    //===========================================================================================================


    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_invoice')]/li[2]")
    private WebElement FirstNameAndLastNameFromBA;
    private WebElement getFirstNameAndLastNameFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_invoice')]/li[2]", Locator.XPath)) {
            return this.FirstNameAndLastNameFromBA; } else { return null; }
    }
    public String getFirstNameFromBA(){
        return doGetText(this.getFirstNameAndLastNameFromBA()).split(" ")[0].trim();
    }
    public String getLastNameFromBA(){
        return doGetText(this.getFirstNameAndLastNameFromBA()).split(" ")[1].trim();
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_invoice')]/li[3]")
    private WebElement companyNameFromBA;
    private WebElement getcompanyNameFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_invoice')]/li[3]", Locator.XPath)) {
            return this.companyNameFromBA; } else { return null; }
    }
    public String getCompanyNameFromBA(){
        return this.doGetText(getcompanyNameFromBA());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_invoice')]/li[4]")
    private WebElement AddressAndAddressLineTwoFromBA;
    private WebElement getAddressAndAddressLineTwoFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_invoice')]/li[4]", Locator.XPath)) {
            return this.AddressAndAddressLineTwoFromBA; } else { return null; }
    }
    public String getAddressFromBA(){
        return doGetText(this.getAddressAndAddressLineTwoFromBA()).split(" ")[0].trim();
    }
    public String getAddressLineTwoFromBA(){
        return doGetText(this.getAddressAndAddressLineTwoFromBA()).split(" ")[1].trim()+" "+doGetText(this.getAddressAndAddressLineTwoFromBA()).split(" ")[2].trim();
    }


    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_invoice')]/li[5]")
    private WebElement CityAndStateAndPinFromBA;
    private WebElement getCityAndStateAndPinFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_invoice')]/li[5]", Locator.XPath)) {
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


    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_invoice')]/li[6]")
    private WebElement countryNameFromBA;
    private WebElement getcountryNameFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_invoice')]/li[6]", Locator.XPath)) {
            return this.countryNameFromBA; } else { return null; }
    }
    public String getCountryNameFromBA(){
        return this.doGetText(getcountryNameFromBA());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_invoice')]/li[7]")
    private WebElement homeNumberFromBA;
    private WebElement gethomeNumberFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_invoice')]/li[7]", Locator.XPath)) {
            return this.homeNumberFromBA; } else { return null; }
    }
    public String getHomeNumberFromBA(){
        return this.doGetText(gethomeNumberFromBA());
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_invoice')]/li[8]")
    private WebElement mobilenumberFromBA;
    private WebElement getmobilenumberFromBA() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_invoice')]/li[8]", Locator.XPath)) {
            return this.mobilenumberFromBA; } else { return null; }
    }
    public String getMobileNumberFromBA(){
        return this.doGetText(getmobilenumberFromBA());
    }
//=========================================================================================















    //====================================================================================================

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_delivery')]/descendant::span[contains(text(),'Update')]")
    private WebElement btnUpdateDeliveryAddress;
    public WebElement getBtnUpdateDeliveryAddress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_delivery')]/descendant::span[contains(text(),'Update')]", Locator.XPath)) {
            return this.btnUpdateDeliveryAddress; } else { return null; }
    }
    public void clkBtnUpdateDeliveryAddress()throws TimeoutException,NullPointerException {
        doClick(getBtnUpdateDeliveryAddress());
    }


    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'address_invoice')]/descendant::span[contains(text(),'Update')]")
    private WebElement btnUpdateBillingAddress;
    public WebElement getBtnUpdateBillingAddress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'address_invoice')]/descendant::span[contains(text(),'Update')]", Locator.XPath)) {
            return this.btnUpdateBillingAddress; } else { return null; }
    }
    public void clkBtnUpdateBillingAddress()throws TimeoutException,NullPointerException {
        doClick(getBtnAddNewAddress());
    }

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'If you would like to add a comment about your order, please write it in the field below.')]/ancestor::div[1]/preceding-sibling::p/descendant::span[1]")
    private WebElement btnAddNewAddressTwo;
    public WebElement getBtnAddNewAddressTwo() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//label[contains(text(),'If you would like to add a comment about your order, please write it in the field below.')]/ancestor::div[1]/preceding-sibling::p/descendant::span[1]", Locator.XPath)) {
            return this.btnAddNewAddressTwo; } else { return null; }
    }
    public PageYourAddress clkBtnAddNewAddressTwo()throws TimeoutException,NullPointerException {
        doClick(getBtnAddNewAddressTwo());
        return new PageYourAddress(driver);
    }

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'If you would like to add a comment about your order, please write it in the field below.')]/following-sibling::textarea")
    private WebElement txtComment;
    public WebElement getTxtComment() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//label[contains(text(),'If you would like to add a comment about your order, please write it in the field below.')]/following-sibling::textarea", Locator.XPath)) {
            return this.txtComment; } else { return null; }
    }
    public void passComment(String comment){
        this.doSendKeys(getTxtComment(),comment);
    }

    @FindBy(how = How.XPATH, using = "//button[contains(@name,'processAddress')]/preceding-sibling::a[1]")
    private WebElement btnContinueShopping;
    public WebElement getBtnContinueShopping() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@name,'processAddress')]/preceding-sibling::a[1]", Locator.XPath)) {
            return this.btnContinueShopping; } else { return null; }
    }
    public void clkBtnContinueShopping()throws TimeoutException,NullPointerException {
        doClick(getBtnContinueShopping());
    }

    @FindBy(how = How.XPATH, using = "//button[contains(@name,'processAddress')]")
    private WebElement btnProceedToCheckOut;
    public WebElement getBtnProceedToCheckOut() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@name,'processAddress')]", Locator.XPath)) {
            return this.btnProceedToCheckOut; } else { return null; }
    }
    public void clkBtnProceedToCheckOut()throws TimeoutException,NullPointerException {
        doClick(getBtnProceedToCheckOut());
    }



    @FindBy(how = How.XPATH, using = "//div[contains(@id,'address_invoice_form')]/descendant::span[2]")
    private WebElement loader;
    public WebElement getLoader() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'address_invoice_form')]/descendant::span[2]", Locator.XPath)) {
            return this.loader; } else { return null; }
    }
















}
