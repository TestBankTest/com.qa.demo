package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageProductDetails extends PageBase{

    public WebDriver driver;
    public PageProductDetails(WebDriver webDriver){
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Return to Home')]/ancestor::div[1]")
    private WebElement lblProductName;
    public WebElement getLblProductName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@title,'Return to Home')]/ancestor::div[1]", Locator.XPath)) {
            return this.lblProductName; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//h1[contains(@itemprop,'name')]")
    private WebElement lblPName;
    public WebElement getLblPName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h1[contains(@itemprop,'name')]", Locator.XPath)) {
            return this.lblPName; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//span[contains(@id,'our_price_display')]")
    private WebElement productPrice;
    public WebElement ProductPrice() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'our_price_display')]", Locator.XPath)) {
            return this.productPrice; } else { return null; }
    }
    public Double getProductPrice(){
            return Double.parseDouble(this.doGetText(this.productPrice).replace("$",""));
    }

/*
    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "")
    private WebElement ;
    public WebElement get() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("", Locator.XPath)) {
            return this.; } else { return null; }
    }

*/






















}
