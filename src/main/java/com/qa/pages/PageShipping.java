package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageShipping extends PageBase{
    public WebDriver driver;
    public PageShipping(WebDriver webDriver){
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Shipping')]")
    private WebElement lblShipping;
    public WebElement getLblShipping() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h1[contains(text(),'Shipping')]", Locator.XPath)) {
            return this.lblShipping; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//form[contains(@name,'carrier_area')]/descendant::p[1]")
    private WebElement shippingAddressName;
    private WebElement ShippingAddressName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//form[contains(@name,'carrier_area')]/descendant::p[1]", Locator.XPath)) {
            return this.shippingAddressName; } else { return null; }
    }
    public String getShippingAddressName(){
        System.out.println("h1 " +doGetText(ShippingAddressName()).split(":")[0].trim());
        System.out.println("h2 " +doGetText(ShippingAddressName()).split(":")[1].trim());

        return doGetText(ShippingAddressName()).split(":")[1].trim();
    }












    @FindBy(how = How.XPATH, using = "//td[contains(@class,'delivery_option_price')]")
    private WebElement deliveryCost;
    public WebElement getDeliveryCost() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//td[contains(@class,'delivery_option_price')]", Locator.XPath)) {
            return this.deliveryCost; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'My carrier')]/ancestor::td[1]")
    private WebElement deliveryStatus;
    public WebElement getDeliveryStatus() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//strong[contains(text(),'My carrier')]/ancestor::td[1]", Locator.XPath)) {
            return this.deliveryStatus; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'cgv')]")
    private WebElement chkTermsAndCondition;
    public WebElement getChkTermsAndCondition() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@id,'cgv')]", Locator.XPath)) {
            return this.chkTermsAndCondition; } else { return null; }
    }

    public void clkChkTermsAndCondition()throws TimeoutException,NullPointerException {
        doClick(getChkTermsAndCondition());
    }


    @FindBy(how = How.XPATH, using = "//a[contains(text(),'(Read the Terms of Service)')]")
    private WebElement lnkLblTermsAndCondition;
    public WebElement getLnkLblTermsAndCondition() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'(Read the Terms of Service)')]", Locator.XPath)) {
            return this.lnkLblTermsAndCondition; } else { return null; }
    }

    public void clkLnkLblTermsAndCondition()throws TimeoutException,NullPointerException {
        doClick(getLnkLblTermsAndCondition());
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

    @FindBy(how = How.XPATH, using = "//button[contains(@name,'processCarrier')]")
    private WebElement btnProceedToCheckOut;
    public WebElement getBtnProceedToCheckOut() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@name,'processCarrier')]", Locator.XPath)) {
            return this.btnProceedToCheckOut; } else { return null; }
    }
    public void clkBtnProceedToCheckOut()throws TimeoutException,NullPointerException {
        doClick(getBtnProceedToCheckOut());

    }

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'You must agree to the terms of service before continuing.')]")
    private WebElement altMsgOfTermsAndCondition;
    public WebElement getAltMsgOfTermsAndCondition() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//p[contains(text(),'You must agree to the terms of service before continuing.')]", Locator.XPath)) {
            return this.altMsgOfTermsAndCondition; } else { return null; }
    }

    public Integer getAvailabilityStatusOfAltMsgOfTermsAndCondition(){
        int availabilityStatus=0;
        try{
            if(verifyPresentOfElement("//p[contains(text(),'You must agree to the terms of service before continuing.')]", Locator.XPath)){
                availabilityStatus=1;
            }
        }catch (NoSuchElementException noSuchElementException){
            availabilityStatus=0;
        }return availabilityStatus;
    }



    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Close')]")
    private WebElement btnCloseAlertMsg;
    public WebElement getBtnCloseAlertMsg() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@title,'Close')]", Locator.XPath)) {
            return this.btnCloseAlertMsg; } else { return null; }
    }
    public Integer getAvailabilityStatusOfBtnCloseAlertMsg(){
        Integer availabilityStatus=0;
        try{
            if(verifyPresentOfElement("pageShipping.getBtnCloseAlertMsg()",Locator.XPath)){
                availabilityStatus=1;
            }
        }catch (NoSuchElementException noSuchElementException){
            availabilityStatus=0;
        }return availabilityStatus;
    }




    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Terms and conditions of use')]")
    private WebElement lblTermsAndConditionsOfUse;
    public WebElement getLblTermsAndConditionsOfUse() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h1[contains(text(),'Terms and conditions of use')]", Locator.XPath)) {
            return this.lblTermsAndConditionsOfUse; } else { return null; }
    }













































}
