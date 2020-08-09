package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageOrderConfirmation extends PageBase{

    WebDriver driver;
    public PageOrderConfirmation(WebDriver driver) {
        super(driver);
        try{ this.driver=driver;
            PageFactory.initElements(this.driver,this);
        }catch (Exception ae){
            ae.printStackTrace(); }
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Order confirmation')]")
    private WebElement lblOrderConfirmation;
    public WebElement getLblOrderConfirmation() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h1[contains(text(),'Order confirmation')]", Locator.XPath)) {
            return this.lblOrderConfirmation; } else { return null; }
    }







    @FindBy(how = How.XPATH, using = "//span[contains(@class,'price')]/strong[1]")
    private WebElement productAmount;
    public WebElement getProductAmount() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@class,'price')]/strong[1]", Locator.XPath)) {
            return this.productAmount; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Your order on My Store is complete.')]/ancestor::div[1]/descendant::strong[3]")
    private WebElement nameAccountOwner;
    public WebElement getNameAccountOwner() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//strong[contains(text(),'Your order on My Store is complete.')]/ancestor::div[1]/descendant::strong[3]", Locator.XPath)) {
            return this.nameAccountOwner; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Your order on My Store is complete.')]/ancestor::div[1]/descendant::strong[4]")
    private WebElement Details;
    public WebElement getDetails() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//strong[contains(text(),'Your order on My Store is complete.')]/ancestor::div[1]/descendant::strong[4]", Locator.XPath)) {
            return this.Details; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Your order on My Store is complete.')]/ancestor::div[1]/descendant::strong[5]")
    private WebElement bankName;
    public WebElement getBankName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//strong[contains(text(),'Your order on My Store is complete.')]/ancestor::div[1]/descendant::strong[5]", Locator.XPath)) {
            return this.bankName; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'order_step')]/following-sibling::div[1]")
    private WebElement referenceNumber;
    private WebElement ReferenceNumber() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'order_step')]/following-sibling::div[1]", Locator.XPath)) {
            return this.referenceNumber; } else { return null; }
    }

    public String getReferenceNumber(){
        return doGetText(referenceNumber).split("-")[5].split(" ")[9];
    }






    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Back to orders')]")
    private WebElement btnBackToOrder;
    public WebElement getBtnBackToOrder() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@title,'Back to orders')]", Locator.XPath)) {
            return this.btnBackToOrder; } else { return null; }
    }

    public void clkBtnBackToOrder(){
        doClick(getBtnBackToOrder());
    }














}
