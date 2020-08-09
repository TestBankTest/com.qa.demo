package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageCart extends PageBase{

    WebDriver driver;
    public PageCart(WebDriver driver) {
        super(driver);
        try{ this.driver=driver;
            PageFactory.initElements(this.driver,this);
        }catch (Exception ae){
            ae.printStackTrace(); }
    }


//cart page object repository.....................

    @FindBy(how = How.XPATH, using = "//b[contains(text(),'Cart')]/following-sibling::span[1]")
    private WebElement cartProductCount;
    public WebElement getCartProductCount() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//b[contains(text(),'Cart')]/following-sibling::span[1]", Locator.XPath)) {
            return this.cartProductCount; } else { return null; }
    }

    public List<WebElement> getCartProductName(String productName) throws  TimeoutException, NotFoundException,NullPointerException {
        String Pname = "";
        if(productName.length()>=10){ Pname=productName.substring(0,10)+"."+"."+"."; }else {Pname=productName; }
            if (verifyPresentOfElement("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'" + Pname + "')]", Locator.XPath)) {
                return this.driver.findElements(By.xpath("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'" + Pname + "')]"));
            } else { return null; }
    }

    public Integer getProduct(String productName,String productPrice){
        String Pname = "";
        Integer Status = 0;
        try { if (productName.length() >= 10) {
                Pname = productName.substring(0, 10) + "." + "." + "."; } else { Pname = productName; }
              if (verifyPresentOfElement("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'" + Pname + "')]/ancestor::div[1]/following-sibling::div/following-sibling::span[contains(text(),'" + productPrice + "')]", Locator.XPath)) {
                Status=1;}
        }catch (NoSuchElementException noSuchElementException){
            Status=0; }return Status;
    }

    public WebElement getCartProductPrice(String productName) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        String Pname = "";
        if(productName.length()>=10){
            Pname=productName.substring(0,10)+"."+"."+"."; }else {Pname=productName;}
        if (verifyPresentOfElement("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'"+Pname+"')]/ancestor::div[2]/span[contains(@class,'price')]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'"+Pname+"')]/ancestor::div[2]/span[contains(@class,'price')]")); } else { return null; }
    }

    private WebElement getCartProductAttribute(String productName,String productPrice) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        String Pname = "";
        if(productName.length()>=10){
            Pname=productName.substring(0,10)+"."+"."+".";
        }else {Pname=productName;}
        if (verifyPresentOfElement("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'"+Pname+"')]/ancestor::div[2]/descendant::span[contains(text(),'"+productPrice+"')]/ancestor::div[1]/descendant::a[2]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'"+Pname+"')]/ancestor::div[2]/descendant::span[contains(text(),'"+productPrice+"')]/ancestor::div[1]/descendant::a[2]")); } else { return null;}
    }

    public String getCartProductColor(String productName,String productPrice){
        String productValue[]=doGetText(getCartProductAttribute(productName,productPrice)).split(",");
        String color=productValue[0].trim();
        return color;
    }

    public String getCartProductSize(String productName,String productPrice){
        String productValue[]=doGetText(getCartProductAttribute(productName,productPrice)).split(",");
        String size=productValue[1].trim();
        return size;
    }

    public WebElement getCartProductQuantity(String productName,String productPrice) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        String Pname = "";
        if(productName.length()>=10){ Pname=productName.substring(0,10)+"."+"."+".";
        }else {Pname=productName;}
        if (verifyPresentOfElement("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'"+Pname+"')]/ancestor::div[2]/descendant::span[contains(text(),'"+productPrice+"')]/ancestor::div[1]/descendant::span[contains(@class,'quantity')][2]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'"+Pname+"')]/ancestor::div[2]/descendant::span[contains(text(),'"+productPrice+"')]/ancestor::div[1]/descendant::span[contains(@class,'quantity')][2]")); } else { return null; }
    }

    public WebElement getBtnRemove(String productName,String productPrice) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        String Pname = "";
        if(productName.length()>=10){ Pname=productName.substring(0,10)+"."+"."+".";
        }else {Pname=productName;}
        if (verifyPresentOfElement("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'"+Pname+"')]/ancestor::div[2]/descendant::span[contains(text(),'"+productPrice+"')]/ancestor::div[1]/following-sibling::span[contains(@class,'remove_link')]", Locator.XPath)) {
            return this.driver.findElement(By.xpath("//a[contains(@title,'View my shopping cart')]/following-sibling::div[1]/descendant::a[contains(text(),'"+Pname+"')]/ancestor::div[2]/descendant::span[contains(text(),'"+productPrice+"')]/ancestor::div[1]/following-sibling::span[contains(@class,'remove_link')]")); } else { return null; }
    }

    public void clkBtnRemove(String productName,String productPrice)throws TimeoutException,NullPointerException {
        doClick(getBtnRemove(productName,productPrice));
    }

    @FindBys(@FindBy(how=How.XPATH, using = "//b[contains(text(),'Cart')]/ancestor::a[1]/following-sibling::div[1]/descendant::a[4]"))
    List<WebElement> btnRemoveAllProduct;
    public List<WebElement> getBtnRemoveAllProduct() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//b[contains(text(),'Cart')]/ancestor::a[1]/following-sibling::div[1]/descendant::a[4]", Locator.XPath)) {
            return this.btnRemoveAllProduct; } else { return null; }
    }
    public void clkBtnRemoveAllProduct(WebElement removeProduct) throws TimeoutException,NullPointerException{
        doClick(removeProduct);
    }

    @FindBy(how=How.XPATH, using = "//span[contains(text(),'Shipping')]/preceding-sibling::span[1]")
    private WebElement shippingCost;
    public WebElement getShippingCost() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(text(),'Shipping')]/preceding-sibling::span[1]", Locator.XPath)) {
            return this.shippingCost; } else { return null; }
    }

    @FindBy(how=How.XPATH, using = "//span[contains(text(),'Total')]/preceding-sibling::span[1]")
    private WebElement totalCost;
    public WebElement getTotalCost() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(text(),'Total')]/preceding-sibling::span[1]", Locator.XPath)) {
            return this.totalCost; } else { return null; }
    }

    @FindBy(how=How.XPATH, using = "//span[contains(text(),'Check out')]")
    private WebElement btnCheckout;
    public WebElement getBtnCheckOut() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(text(),'Check out')]", Locator.XPath)) {
            return btnCheckout; } else { return null; }
    }
    public void clkBtnCheckOut()throws TimeoutException,NullPointerException {
        doClick(getBtnCheckOut());
    }





















}


















