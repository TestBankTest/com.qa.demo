package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageBankWirePayment extends PageBase{

    WebDriver driver;
    public PageBankWirePayment(WebDriver driver) {
        super(driver);
        try{ this.driver=driver;
            PageFactory.initElements(this.driver,this);
        }catch (Exception ae){
            ae.printStackTrace(); }
    }


    @FindBy(how = How.XPATH, using = "//h3[contains(text(),'Bank-wire payment.')]")
    private WebElement lblBankWirePayment;
    public WebElement getLblBankWirePayment() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h3[contains(text(),'Bank-wire payment.')]", Locator.XPath)) {
            return this.lblBankWirePayment; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//span[contains(@id,'amount')]")
    private WebElement productAmount;
    public WebElement getProductAmount() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'amount')]", Locator.XPath)) {
            return this.productAmount; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'We allow the following currency to be sent via bank wire:')]/b[1]")
    private WebElement currencyType;
    public WebElement getCurrencyType() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//p[contains(text(),'We allow the following currency to be sent via bank wire:')]/b[1]", Locator.XPath)) {
            return this.currencyType; } else { return null; }
    }


    @FindBy(how=How.XPATH, using = "//span[contains(text(),'I confirm my order')]/ancestor::button[1]/preceding-sibling::a[1]")
    private WebElement btnOtherPaymentMethods;
    public WebElement getBtnOtherPaymentMethods() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(text(),'I confirm my order')]/ancestor::button[1]/preceding-sibling::a[1]", Locator.XPath)) {
            return btnOtherPaymentMethods; } else { return null; }
    }
    public void clkBtnOtherPaymentMethods()throws TimeoutException,NullPointerException {
        doClick(getBtnOtherPaymentMethods());
    }

    @FindBy(how=How.XPATH, using = "//span[contains(text(),'I confirm my order')]")
    private WebElement btnConfirmMyOrder;
    public WebElement getBtnConfirmMyOrder() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(text(),'I confirm my order')]", Locator.XPath)) {
            return btnConfirmMyOrder; } else { return null; }
    }
    public void clkBtnConfirmMyOrder()throws TimeoutException,NullPointerException {
        doClick(getBtnConfirmMyOrder());
    }
















}
