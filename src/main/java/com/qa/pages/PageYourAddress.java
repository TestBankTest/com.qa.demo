package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageYourAddress extends PageBase{

    public WebDriver driver;
    public PageYourAddress(WebDriver webDriver){
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Your addresses')]")
    private WebElement lblYourAddress;
    public WebElement getLblYourAddress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h1[contains(text(),'Your addresses')]", Locator.XPath)) {
            return this.lblYourAddress; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//input[contains(@name,'firstname')]")
    private WebElement txtFirstName;
    public WebElement getTxtFirstName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@name,'firstname')]", Locator.XPath)) {
            return this.txtFirstName; } else { return null; }
    }

    public void passFirstName(String firstName){
        doSendKeys(getTxtFirstName(),firstName);
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'lastname')]")
    private WebElement txtLastName;
    public WebElement getTxtLastName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@name,'lastname')]", Locator.XPath)) {
            return this.txtLastName; } else { return null; }
    }

    public void passLastName(String lastName){
        doSendKeys(getTxtLastName(),lastName);
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'company')]")
    private WebElement txtCompany;
    public WebElement getTxtCompany() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@name,'company')]", Locator.XPath)) {
            return this.txtCompany; } else { return null; }
    }

    public void passCompany(String company){
        doSendKeys(getTxtCompany(),company);
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'address1')]")
    private WebElement txtAddressOne;
    public WebElement getTxtAddressOne() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@name,'address1')]", Locator.XPath)) {
            return this.txtAddressOne; } else { return null; }
    }

    public void passAddressOne(String addrss){
        doSendKeys(getTxtAddressOne(),addrss);
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'address2')]")
    private WebElement txtAddressTwo;
    public WebElement getTxtAddressTwo() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@name,'address2')]", Locator.XPath)) {
            return this.txtAddressTwo; } else { return null; }
    }

    public void passAddressTwo(String address){
        doSendKeys(getTxtAddressTwo(),address);
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'city')]")
    private WebElement txtCity;
    public WebElement getTxtCity() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@name,'city')]", Locator.XPath)) {
            return this.txtCity; } else { return null; }
    }

    public void passCity(String city){
        doSendKeys(getTxtCity(),city);
    }

    @FindBy(how = How.XPATH, using = "//select[contains(@name,'id_state')]")
    private WebElement DDState;
    public WebElement getDDState() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//select[contains(@name,'id_state')]", Locator.XPath)) {
            return this.DDState; } else { return null; }
    }

    public void selectState(String state){
        dropdownHandleUtil.selectValue(getDDState(),state);
    }

    @FindBy(how = How.XPATH, using = "//select[contains(@name,'id_country')]")
    private WebElement DDCountry;
    public WebElement getDDCountry() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//select[contains(@name,'id_country')]", Locator.XPath)) {
            return this.DDCountry; } else { return null; }
    }

    public void selectCountry(String country){
        dropdownHandleUtil.selectValue(getDDCountry(),country);
    }


    @FindBy(how = How.XPATH, using = "//input[contains(@name,'postcode')]")
    private WebElement postalCode;
    public WebElement getPostalCode() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@name,'postcode')]", Locator.XPath)) {
            return this.postalCode; } else { return null; }
    }

    public void passPostalCode(String postalCode){
        doSendKeys(getPostalCode(),postalCode);
    }

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Home phone ')]/following-sibling::input[1]")
    private WebElement txtHomePhone;
    public WebElement getTxtHomePhone() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//label[contains(text(),'Home phone ')]/following-sibling::input[1]", Locator.XPath)) {
            return this.txtHomePhone; } else { return null; }
    }

    public void passHomePhone(String homePhone){
        doSendKeys(getTxtHomePhone(),homePhone);
    }

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Mobile phone ')]/following-sibling::input[1]")
    private WebElement txtMobilePhone;
    public WebElement getTxtMobilePhone() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//label[contains(text(),'Mobile phone ')]/following-sibling::input[1]", Locator.XPath)) {
            return this.txtMobilePhone; } else { return null; }
    }

    public void passMobilePhone(String mobilePhone){
        doSendKeys(getTxtMobilePhone(),mobilePhone);
    }

    @FindBy(how = How.XPATH, using = "//textarea[contains(@name,'other')]")
    private WebElement txtAdditionInformation;
    public WebElement getTxtAdditionInformation() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//textarea[contains(@name,'other')]", Locator.XPath)) {
            return this.txtAdditionInformation; } else { return null; }
    }

    public void passAdditionInformation(String additionInformation){
        doSendKeys(getTxtAdditionInformation(),additionInformation);
    }


    @FindBy(how = How.XPATH, using = "//input[contains(@name,'alias')]")
    private WebElement addressTitleForFutureReference;
    public WebElement getAddressTitleForFutureReference() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@name,'alias')]", Locator.XPath)) {
            return this.txtLastName; } else { return null; }
    }
    public void passAddressTitleForFutureReference(String addressTitleForFutureReference){
        this.doSendKeys(getAddressTitleForFutureReference(),addressTitleForFutureReference);
    }



    @FindBy(how = How.XPATH, using = "//button[contains(@name,'submitAddress')]")
    private WebElement btnSave;
    public WebElement getBtnSave() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@name,'submitAddress')]", Locator.XPath)) {
            return this.btnSave; } else { return null; }
    }

    public void clkBtnSave()throws TimeoutException,NullPointerException {
        doClick(getBtnSave());
    }



    @FindBy(how = How.XPATH, using = "//button[contains(@name,'processAddress')]")
    private WebElement btnProceedtoCheckout;
    public WebElement getBtnProceedtoCheckout() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@name,'processAddress')]", Locator.XPath)) {
            return this.btnProceedtoCheckout; } else { return null; }
    }

    public void clkBtnProceedtoCheckout()throws TimeoutException,NullPointerException {
        doClick(getBtnProceedtoCheckout());
    }


































}
