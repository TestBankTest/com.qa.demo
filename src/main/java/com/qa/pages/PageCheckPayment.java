package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageCheckPayment extends PageBase{

    WebDriver driver;
    public PageCheckPayment(WebDriver driver) {
        super(driver);
        try{ this.driver=driver;
            PageFactory.initElements(this.driver,this);
        }catch (Exception ae){
            ae.printStackTrace(); }
    }

    @FindBy(how = How.XPATH, using = "//h3[contains(text(),'Check payment')]")
    private WebElement lblCheckPayment;
    public WebElement getLblCheckPayment() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h3[contains(text(),'Check payment')]", Locator.XPath)) {
            return this.lblCheckPayment; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//span[contains(@id,'amount')]")
    private WebElement productAmount;
    public WebElement getProductAmount() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'amount')]", Locator.XPath)) {
            return this.productAmount; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'We allow the following currencies to be sent by check')]/b[1]")
    private WebElement currencyType;
    public WebElement getCurrencyType() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//p[contains(text(),'We allow the following currencies to be sent by check')]/b[1]", Locator.XPath)) {
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
