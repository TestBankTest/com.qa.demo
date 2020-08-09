package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PagePayment extends PageBase{

    public WebDriver driver;
    public PagePayment(WebDriver webDriver){
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Please choose your payment method')]")
    private WebElement lblChooseYourPaymentMethod;
    public WebElement getLblChooseYourPaymentMethod() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h1[contains(text(),'Please choose your payment method')]", Locator.XPath)) {
            return this.lblChooseYourPaymentMethod; } else { return null; }
    }

//===================================================================================================================

    @FindBy(how = How.XPATH, using = "//td[contains(@class,'cart_unit')]/following-sibling::td[1]/span")
    private WebElement productQuantity;
    public WebElement getProductQuantity() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//td[contains(@class,'cart_unit')]/following-sibling::td[1]/span", Locator.XPath)) {
            return this.productQuantity; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//td[contains(@class,'cart_total')]")
    private WebElement productTotalPrice;
    public WebElement getProductTotalPrice() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//td[contains(@class,'cart_total')]", Locator.XPath)) {
            return this.productTotalPrice; } else { return null; }
    }


    //========================================================================================================

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Pay by bank wire')]")
    private WebElement btnPayByBankWire;
    public WebElement getBtnPayByBankWire() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Pay by bank wire')]", Locator.XPath)) {
            return this.btnPayByBankWire; } else { return null; }
    }
    public void clkBtnPayByBankWire()throws TimeoutException,NullPointerException {
        doClick(getBtnPayByBankWire());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Pay by check')]")
    private WebElement btnPayByCheck;
    public WebElement getBtnPayByCheck() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Pay by check')]", Locator.XPath)) {
            return this.btnPayByCheck; } else { return null; }
    }
    public void clkBtnPayByCheck()throws TimeoutException,NullPointerException {
        doClick(getBtnPayByCheck());
    }





































}
