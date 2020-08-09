package com.qa.pages;

import com.qa.base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageBase extends Base {

    public WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver=driver;
    }

    public void getCurrentUrl(){
        String currentUrl;
        try{
            currentUrl=this.driver.getCurrentUrl();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public String doGetCurrentUrl(){
        String currentUrl="";
        try{
            currentUrl=this.driver.getCurrentUrl();
        }catch (Exception ae){
            ae.printStackTrace();
        }return currentUrl;
    }



    public void doClick(WebElement element){
        WebElement Temp=null;
        try{
            element.click();
        }
        catch (UnhandledAlertException unhandledAlertException){
            unhandledAlertException.printStackTrace();
            this.alertHandleUtil.dismissAlert();
            doClick(element);
        }catch (ElementNotVisibleException elementNotVisibleException){
            try {
                this.actionsHandleUtil.moveElement(element);
                if(!element.isDisplayed()){
                    jsHandleUtil.doScrollByWebElement(element);
                }
                Temp = webDriverWait.until(ExpectedConditions.visibilityOf(element));
                Temp=webDriverWait.until(ExpectedConditions.elementToBeClickable(Temp));
                doClick(Temp);
            }catch (TimeoutException timeoutException){
                throw new TimeoutException("Element not visible"+timeoutException);
            }
        }catch (InvalidElementStateException invalidElementStateException){
                 try {
                     this.jsHandleUtil.doClickElement(element);
                 }catch (InvalidElementStateException invalidElementStateException1) {
                     throw new InvalidElementStateException("invalidElementStateException" + invalidElementStateException);
                 }
        }
        catch (WebDriverException webDriverException){
            try{

                Temp=webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
                doClick(Temp);
            }catch (TimeoutException timeoutException){
                throw new TimeoutException("Element not clickable "+timeoutException);
            }
        }
    }

    public void doSendKeys(WebElement element,String value){
        WebElement Temp=null;
        try{
            element.sendKeys(value);
        }catch (UnhandledAlertException unhandledAlertException){
            unhandledAlertException.printStackTrace();
            this.alertHandleUtil.dismissAlert();
            doSendKeys(element,value);
        }catch (ElementNotVisibleException elementNotVisibleException){
            try {
                this.actionsHandleUtil.moveElement(element);
                if(!element.isDisplayed()){
                    jsHandleUtil.doScrollByWebElement(element);
                }
                Temp = webDriverWait.until(ExpectedConditions.visibilityOf(element));
                Temp=webDriverWait.until(ExpectedConditions.elementToBeClickable(Temp));
                doSendKeys(Temp,value);
            }catch (TimeoutException timeoutException){
                throw new TimeoutException("Element not visible"+timeoutException);
            }
        }catch (InvalidElementStateException invalidElementStateException){
            throw new InvalidElementStateException("invalidElementStateException"+invalidElementStateException);
        }catch (WebDriverException webDriverException){
            try{
                Temp=webDriverWait.until(ExpectedConditions.elementToBeClickable(Temp));
                doSendKeys(Temp,value);
            }catch (TimeoutException timeoutException){
                throw new TimeoutException("Element not clickable "+timeoutException);
            }
        }
    }

    public String doGetText(WebElement element){
        WebElement Temp=null;
        String text="";
        try{
            text=element.getText();
        }catch (UnhandledAlertException unhandledAlertException){
            unhandledAlertException.printStackTrace();
            this.alertHandleUtil.dismissAlert();
            doGetText(element);
        }catch (ElementNotVisibleException elementNotVisibleException){
            try {
                this.actionsHandleUtil.moveElement(element);
                if(!element.isDisplayed()){
                    jsHandleUtil.doScrollByWebElement(element);
                }
                Temp = webDriverWait.until(ExpectedConditions.visibilityOf(element));
                Temp=webDriverWait.until(ExpectedConditions.elementToBeClickable(Temp));
                doGetText(Temp);
            }catch (TimeoutException timeoutException){
                throw new TimeoutException("Element not visible"+timeoutException);
            }
        }catch (InvalidElementStateException invalidElementStateException){
            throw new InvalidElementStateException("invalidElementStateException"+invalidElementStateException);
        }catch (WebDriverException webDriverException){
            try{
                Temp=webDriverWait.until(ExpectedConditions.elementToBeClickable(Temp));
                doGetText(Temp);
            }catch (TimeoutException timeoutException){
                throw new TimeoutException("Element not clickable "+timeoutException);
            }
        }return text;
    }

    public void doClear(WebElement element){
        WebElement Temp=null;
        try{
            element.clear();
        }catch (UnhandledAlertException unhandledAlertException){
            unhandledAlertException.printStackTrace();
            this.alertHandleUtil.dismissAlert();
            doClear(element);
        }catch (ElementNotVisibleException elementNotVisibleException){
            try {
                this.actionsHandleUtil.moveElement(element);
                if(!element.isDisplayed()){
                    jsHandleUtil.doScrollByWebElement(element);
                }
                Temp = webDriverWait.until(ExpectedConditions.visibilityOf(element));
                Temp=webDriverWait.until(ExpectedConditions.elementToBeClickable(Temp));
                doClear(Temp);
            }catch (TimeoutException timeoutException){
                throw new TimeoutException("Element not visible"+timeoutException);
            }
        }catch (InvalidElementStateException invalidElementStateException){
            throw new InvalidElementStateException("invalidElementStateException"+invalidElementStateException);
        }catch (WebDriverException webDriverException){
            try{
                Temp=webDriverWait.until(ExpectedConditions.elementToBeClickable(Temp));
                doClear(Temp);
            }catch (TimeoutException timeoutException){
                throw new TimeoutException("Element not clickable "+timeoutException);
            }
        }
    }












    public boolean verifyPresentOfElement(String locator,Locator locatorStrategy){
        boolean presenceOfElement=false;
        WebElement TempElement=null;
            try{
                switch (locatorStrategy){
                    case id:TempElement=webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
                        break;
                    case name:TempElement=webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
                        break;
                    case cssSelector:TempElement=webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
                        break;
                    case linkText:TempElement=webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator)));
                        break;
                    case partiallyLinkText:TempElement=webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locator)));
                        break;

                    case XPath:TempElement=webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                        break;
                    case tagName:TempElement=webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locator)));
                        break;
                    default:
                }
            }catch (NoSuchElementException noSuchElementException){
                throw new NoSuchElementException("Element Not Found"+noSuchElementException);
            }catch (TimeoutException timeoutException){
                throw new NoSuchElementException("Element Not Found"+timeoutException);
            }catch (NotFoundException notFoundException){
                throw new NoSuchElementException("Element Not Found"+notFoundException);
            }
        if(TempElement==null){
            throw new NoSuchElementException("Element Not Found");
        }else{
            return presenceOfElement=true;
        }
    }

    //Mention all common webElement here..


    @FindBy(how = How.XPATH, using = "//table[contains(@id,'cart_summary')]/descendant::p[contains(@class,'product-name')]/a[1]")
    private WebElement productName;
    public WebElement getProductName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'cart_summary')]/descendant::p[contains(@class,'product-name')]/a[1]", Locator.XPath)) {
            return this.productName; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//table[contains(@id,'cart_summary')]/descendant::a[contains(text(),'Color')]")
    private WebElement productAttribute;

    public String getProductColor(){
        return  this.doGetText(productAttribute).split(",")[0].split(":")[1].trim();
    }

    public String getProductSize(){
        return  this.doGetText(productAttribute).split(",")[1].split(":")[1].trim();
    }

    @FindBy(how = How.XPATH, using = "//table[contains(@id,'cart_summary')]/descendant::td[contains(@class,'cart_avail')]/span[1]")
    private WebElement productStockStatus;
    public WebElement getProductStockStatus() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'cart_summary')]/descendant::td[contains(@class,'cart_avail')]/span[1]", Locator.XPath)) {
            return this.productStockStatus; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//table[contains(@id,'cart_summary')]/descendant::td[contains(@class,'cart_unit')]/span[1]")
    private WebElement productUnitPrice;
    public WebElement getProductUnitPrice() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'cart_summary')]/descendant::td[contains(@class,'cart_unit')]/span[1]", Locator.XPath)) {
            return this.productUnitPrice; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//td[contains(@id,'total_product')]")
    private WebElement totalProductPrice;
    public WebElement getTotalProductPrice() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//td[contains(@id,'total_product')]", Locator.XPath)) {
            return this.totalProductPrice; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//td[contains(@id,'total_shipping')]")
    private WebElement productTotalShippingCost;
    public WebElement getProductTotalShippingCost() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//td[contains(@id,'total_shipping')]", Locator.XPath)) {
            return this.productTotalShippingCost; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//td[contains(@id,'total_price_container')]")
    private WebElement productFinalTotal;
    public WebElement getProductFinalTotal() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//td[contains(@id,'total_price_container')]", Locator.XPath)) {
            return this.productFinalTotal; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Continue shopping')]/preceding-sibling::a[1]/span[1]")
    private WebElement btnProceedToCheckOut;
    public WebElement getBtnProceedToCheckOut() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@title,'Continue shopping')]/preceding-sibling::a[1]/span[1]", Locator.XPath)) {
            return this.btnProceedToCheckOut; } else { return null; }
    }
    public void clkBtnProceedToCheckOut()throws TimeoutException,NullPointerException {
        doClick(getBtnProceedToCheckOut());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Continue shopping')]")
    private WebElement btnContinueShopping;
    public WebElement getBtnContinueShopping() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@title,'Continue shopping')]", Locator.XPath)) {
            return this.btnContinueShopping; } else { return null; }
    }
    public void clkBtnContinueShopping()throws TimeoutException,NullPointerException {
        doClick(getBtnContinueShopping());
    }













































}
