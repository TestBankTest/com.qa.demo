package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

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


    @FindBy(how = How.XPATH, using = "//input[contains(@id,'quantity_wanted')]/ancestor::p[1]/descendant::i[1]")
    private WebElement btnQuantityMinus;
    public WebElement getBtnQuantityMinus() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@id,'quantity_wanted')]/ancestor::p[1]/descendant::i[1]", Locator.XPath)) {
            return this.btnQuantityMinus; } else { return null; }
    }
    public void clkBtnQuantityMinus(){
        doClick(getBtnQuantityMinus());
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'quantity_wanted')]/ancestor::p[1]/descendant::i[2]")
    private WebElement btnQuantityPlus;
    public WebElement getBtnQuantityPlus() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@id,'quantity_wanted')]/ancestor::p[1]/descendant::i[2]", Locator.XPath)) {
            return this.btnQuantityPlus; } else { return null; }
    }
    public void clickBtnQuantityPlus(){
        doClick(getBtnQuantityPlus());
    }


    @FindBy(how = How.XPATH, using = "//input[contains(@id,'quantity_wanted')]")
    private WebElement txtQuantity;
    public WebElement getTxtQuantity() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@id,'quantity_wanted')]", Locator.XPath)) {
            return this.txtQuantity; } else { return null; }
    }

    public Integer getProductQuantity(){
       return Integer.valueOf(getTxtQuantity().getAttribute("value"));
    }

    public void setQuantity(WebElement element,String quantity){
        this.doSendKeys(element,quantity);
    }


    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Size')]/ancestor::fieldset/descendant::select[1]")
    private WebElement ddSize;
    public WebElement getDDSize() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//label[contains(text(),'Size')]/ancestor::fieldset/descendant::select[1]", Locator.XPath)) {
            return this.ddSize; } else { return null; }
    }
    public void selectSize(String size){
        dropdownHandleUtil.selectValue(getDDSize(),size);
    }

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Size')]/ancestor::fieldset/descendant::select[1]/ancestor::div[1]/descendant::span[1]")
    private WebElement Size;
    public WebElement Size() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//label[contains(text(),'Size')]/ancestor::fieldset/descendant::select[1]/ancestor::div[1]/descendant::span[1]", Locator.XPath)) {
            return this.Size; } else { return null; }
    }
    public String getSize(){
        return this.doGetText(Size());
    }


    @FindBys(@FindBy(how=How.XPATH, using = "//label[contains(text(),'Color')]/ancestor::fieldset/descendant::a"))
    List<WebElement> ProductColor;
    public List<WebElement> getProductcolor(){
        if (verifyPresentOfElement("//label[contains(text(),'Color')]/ancestor::fieldset/descendant::a", Locator.XPath)) {
            return this.ProductColor; } else { return null; }
    }
    public List<String> getAllProductColor(){
        List<String>product_Color=new LinkedList<>();
        for(int i=0;i<getProductcolor().size();i++){
            product_Color.add(getProductcolor().get(i).getAttribute("name").trim());
        }return product_Color;
    }
    public void selectProductColor(String productColor){
        Integer flag=0;
      for(WebElement element : getProductcolor()){
          if(element.getAttribute("name").toLowerCase().trim().equals(productColor.toLowerCase().trim())){
              doClick(element);
              flag=1;
              break;
          }
      }if(flag==0){
          throw new RuntimeException("Product Color not available");
        }
    }



    @FindBy(how = How.XPATH, using = "//img[contains(@id,'bigpic')]")
    private WebElement imgBig;
    public WebElement getImgBig() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//img[contains(@id,'bigpic')]", Locator.XPath)) {
            return this.imgBig; } else { return null; }
    }

    @FindBys(@FindBy(how=How.XPATH, using = "//div[contains(@id,'thumbs_list')]/descendant::img"))
    List<WebElement> ProductImages;
    public List<WebElement> ProductImages(){
        if (verifyPresentOfElement("//div[contains(@id,'thumbs_list')]/descendant::img", Locator.XPath)) {
            return this.ProductImages; } else { return null; }
    }
    public List<WebElement> getProductImages(){
        List<WebElement>productImages=new LinkedList<>();
        for(int i=0;i<ProductImages.size();i++){
            if(ProductImages.get(i).isDisplayed()){
                productImages.add(ProductImages.get(i));
            }
        }return productImages;
    }

    public List<String> getAllProductImageNames(){
        List<String>product_Image=new LinkedList<>();
        for(int i=0;i<getProductImages().size();i++){
            product_Image.add(getProductImages().get(i).getAttribute("src").trim());
        }return product_Image;
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@id,'wishlist_button')]")
    private WebElement btnWishlist;
    public WebElement getBtnWishlist() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@id,'wishlist_button')]", Locator.XPath)) {
            return this.btnWishlist; } else { return null; }
    }

    public void clkBtnWishlist(){
        doClick(getBtnWishlist());
    }


    @FindBy(how = How.XPATH, using = "//p[contains(text(),'You must be logged in to manage your wishlist.')]")
    private WebElement alert_LogInRequired;
    public WebElement getAlert_LogInRequired() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//p[contains(text(),'You must be logged in to manage your wishlist.')]", Locator.XPath)) {
            return this.alert_LogInRequired; } else { return null; }
    }
    public boolean verifyPresenceOfAlert_LogInRequired(){
        if(this.doPresenceOfElement("//p[contains(text(),'You must be logged in to manage your wishlist.')]")==1){
            return true;
        }else {
            return false;
        }
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Close')]")
    private WebElement btnCloseAlertLogIn;
    public WebElement getBtnClose() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@title,'Close')]", Locator.XPath)) {
            return this.btnCloseAlertLogIn; } else { return null; }
    }
    public void clkBtnCloseAlertLogIn(){
        doClick(getBtnClose());
    }

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Added to your wishlist.')]")
    private WebElement alertSuccessfulOfWishList;
    public WebElement getAlertSuccessfulOfWishList() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//p[contains(text(),'Added to your wishlist.')]", Locator.XPath)) {
            return this.alertSuccessfulOfWishList; } else { return null; }
    }
    public boolean verifyPresenceOfAlertSuccessfulOfWishList(){
        if(this.doPresenceOfElement("//p[contains(text(),'Added to your wishlist.')]")==1){
            return true;
        }else {
            return false;
        }
    }


    @FindBy(how = How.XPATH, using = "//button[contains(@name,'Submit')]")
    private WebElement btnAddToCart;
    public WebElement getBtnAddToCart() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@name,'Submit')]", Locator.XPath)) {
            return this.btnAddToCart; } else { return null; }
    }
    public void clkBtnAddToCart(){
        doClick(getBtnAddToCart());
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

*/






















}
