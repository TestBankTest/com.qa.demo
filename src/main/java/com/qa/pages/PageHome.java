package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageHome extends PageBase{

    public WebDriver driver;
    public PageHome(WebDriver driver) {
        super(driver);
        try { this.driver = driver;
            PageFactory.initElements(this.driver, this);
        } catch (Exception ae) {
            ae.printStackTrace(); }
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Contact us']")
    private WebElement lnkLblContactUs;
    public WebElement getLnkLblContactUs() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[text()='Contact us']", Locator.XPath)) {
            return this.lnkLblContactUs; } else { return null; }
    }
    public void clkLnkLblContactUs()throws TimeoutException,NullPointerException {
        doClick(getLnkLblContactUs());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
    private WebElement lnkLblSignIn;
    public WebElement getLnkLblSignIn() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Sign in')]", Locator.XPath)) {
            return this.lnkLblSignIn; } else { return null;}
    }
    public void clkLnkLblSignIn()throws TimeoutException,NullPointerException {
        doClick(getLnkLblSignIn());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Contact us')]/ancestor::div[1]/preceding-sibling::div[1]/a[contains(text(),'Sign out')]")
    private WebElement lnkLblSignOut;
    public WebElement getLnkLblSignOut() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Contact us')]/ancestor::div[1]/preceding-sibling::div[1]/a[contains(text(),'Sign out')]", Locator.XPath)) {
            return this.lnkLblSignOut; } else { return null;}
    }
    public void clkLnkLblSignOut()throws TimeoutException,NullPointerException {
        doClick(getLnkLblSignOut());
    }

    public Integer getLnkLblSignInPresenceStatus(){
        Integer presenceElementFlag=0;
        try{
            if (verifyPresentOfElement("//a[contains(text(),'Sign in')]", Locator.XPath)) {
                presenceElementFlag=1; }
        }catch (NoSuchElementException noSuchElementException){
            presenceElementFlag=0;
        }return presenceElementFlag;
    }

    public Integer getLnkLblSignOutPresenceStatus(){
        Integer presenceElementFlag=0;
        try{
            if (verifyPresentOfElement("//a[contains(text(),'Sign out')]", Locator.XPath)) {
                presenceElementFlag=1; }
        }catch (NoSuchElementException noSuchElementException){
            presenceElementFlag=0;
        }return presenceElementFlag;
    }



    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement txtSearch;
    public WebElement getTxtSearch() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("search_query_top", Locator.id)) {
            return this.txtSearch; } else { return null; }
    }
    public void passSearchName(String searchName)throws TimeoutException,NullPointerException {
        doSendKeys(getTxtSearch(),searchName);
    }

    @FindBy(how = How.NAME, using = "search_query_top")
    private WebElement btnSearch;
    public WebElement getBtnSearch() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("search_query_top", Locator.name)) {
            return this.btnSearch; } else { return null; }
    }
    public void clkBtnSearch()throws TimeoutException,NullPointerException {
        doClick(getBtnSearch());
    }

    @FindBy(how = How.XPATH, using = "//b[contains(text(),'Cart')]")
    private WebElement lnkLblCart;
    public WebElement getLnkLblCart() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//b[contains(text(),'Cart')]", Locator.XPath)) {
            return this.lnkLblCart; } else { return null; }
    }
    public void clkLnkLblCart()throws TimeoutException,NullPointerException {
        doClick(getLnkLblCart());
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Women']")
    private WebElement lnkLblWomen;
    public WebElement getLnkLblWomen() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[text()='Women']", Locator.XPath)) {
            return this.lnkLblWomen; } else { return null; }
    }
    public void clkLnkLblWomen()throws TimeoutException,NullPointerException {
        doClick(getLnkLblWomen());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Women') and @title='Women']/ancestor::li[1]/following-sibling::li/a[contains(text(),'Dresse')]")
    private WebElement lnkLblDresses;
    public WebElement getLnkLblDresses() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Women') and @title='Women']/ancestor::li[1]/following-sibling::li/a[contains(text(),'Dresse')]", Locator.XPath)) {
            return this.lnkLblDresses; } else { return null; }
    }
    public void clkLnkLblDresses()throws TimeoutException,NullPointerException {
        doClick(getLnkLblDresses());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Women') and @title='Women']/ancestor::li[1]/following-sibling::li/a[contains(text(),'T-shirts')]")
    private WebElement lnkLblTShirts;
    public WebElement getLnkLblTShirts() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Women') and @title='Women']/ancestor::li[1]/following-sibling::li/a[contains(text(),'T-shirts')]", Locator.XPath)) {
            return this.lnkLblTShirts; } else { return null; }
    }
    public void clkLnkLblTShirts()throws TimeoutException,NullPointerException {
        doClick(getLnkLblTShirts());
    }
    //==============================================Sub menu element===================================================//
    //Women
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'T-shirts') and @title='T-shirts']")
    private WebElement lnkLblTWomenShirts;
    public WebElement getlnkLblTWomenShirts() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'T-shirts') and @title='T-shirts']", Locator.XPath)) {
            return this.lnkLblTWomenShirts; } else { return null; }
    }
    public void clkLnkLblTWomenShirts()throws TimeoutException,NullPointerException {
        doClick(getlnkLblTWomenShirts());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Blouses') and @title='Blouses']")
    private WebElement lnkLblTWomenBlouses;
    public WebElement getLnkLblTWomenBlouses() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Blouses') and @title='Blouses']", Locator.XPath)) {
            return this.lnkLblTWomenShirts; } else { return null; }
    }
    public void clklnkLblTWomenBlouses()throws TimeoutException,NullPointerException {
        doClick(getLnkLblTWomenBlouses());
    }


    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Casual Dresses') and @title='Casual Dresses']")
    private WebElement lnkLblWomenCasualDresses;
    public WebElement getLnkLblWomenCasualDresses() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Casual Dresses') and @title='Casual Dresses']", Locator.XPath)) {
            return this.lnkLblWomenCasualDresses; } else { return null; }
    }
    public void clkLnkLblWomenCasualDresses()throws TimeoutException,NullPointerException {
        doClick(getLnkLblWomenCasualDresses());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Evening Dresses') and @title='Evening Dresses']")
    private WebElement lnkLblWomenEveningDresses;
    public WebElement getLnkLblWomenEveningDresses() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Evening Dresses') and @title='Evening Dresses']", Locator.XPath)) {
            return this.lnkLblWomenEveningDresses; } else { return null; }
    }
    public void clkLnkLblWomenEveningDresses()throws TimeoutException,NullPointerException {
        doClick(getLnkLblWomenEveningDresses());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Summer Dresses') and @title='Summer Dresses']")
    private WebElement lnkLblTWomenSummerDresses;
    public WebElement getLnkLblTWomenSummerDresses() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Summer Dresses') and @title='Summer Dresses']", Locator.XPath)) {
            return this.lnkLblTWomenSummerDresses; } else { return null; }
    }
    public void clkLnkLblTWomenSummerDresses()throws TimeoutException,NullPointerException {
        doClick(getLnkLblTWomenSummerDresses());
    }

    //Dresses
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Casual Dresses') and @title='Casual Dresses']")
    private WebElement lnkLblCasualDress;
    public WebElement getLnkLblCasualDress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Casual Dresses') and @title='Casual Dresses']", Locator.XPath)) {
            return this.lnkLblCasualDress; } else { return null; }
    }
    public void clkLnkLblCasualDress()throws TimeoutException,NullPointerException {
        doClick(getLnkLblCasualDress());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Evening Dresses') and @title='Evening Dresses']")
    private WebElement lnkLblDressesEveningDresses;
    public WebElement getLnkLblDressesEveningDresses() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Evening Dresses') and @title='Evening Dresses']", Locator.XPath)) {
            return this.lnkLblDressesEveningDresses; } else { return null; }
    }
    public void clkLnkLblDressesEveningDresses()throws TimeoutException,NullPointerException {
        doClick(getLnkLblDressesEveningDresses());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Summer Dresses') and @title='Summer Dresses']")
    private WebElement lnkLblDressesSummerDresses;
    public WebElement getLnkLblDressesSummerDresses() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Tops')]/ancestor::li/descendant::a[contains(text(),'Summer Dresses') and @title='Summer Dresses']", Locator.XPath)) {
            return this.lnkLblDressesSummerDresses; } else { return null; }
    }
    public void clkLnkLblDressesSummerDresses()throws TimeoutException,NullPointerException {
        doClick(getLnkLblDressesSummerDresses());
    }

    //==================================================================================================================

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Best Sellers')]")
    private WebElement lnkLblBestSellers;
    public WebElement getLnkLblBestSellers() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Best Sellers')]", Locator.XPath)) {
            return this.lnkLblBestSellers; } else { return null; }
    }
    public void clkLnkLblBestSellers()throws TimeoutException,NullPointerException {
        doClick(getLnkLblBestSellers());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Popular')]")
    private WebElement btnPopular;
    public WebElement getBtnPopular() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Popular')]", Locator.XPath)) {
            return this.btnPopular; } else { return null; }
    }
    public void clkBtnPopular()throws TimeoutException,NullPointerException {
        doClick(getBtnPopular());
    }

    //Product info options.........................................................................................

    @FindBys(@FindBy(how=How.XPATH, using = "//ul[contains(@id,'homefeatured')]/li"))
    List<WebElement> VisibleProductList;
    public List<WebElement> getVisibleProductList(){
        if (verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li", Locator.XPath)) {
            return this.VisibleProductList; } else { return null; }
    }

    public WebElement getProductImage(String productName){
        if(verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]",Locator.XPath)){
            return this.driver.findElement(By.xpath("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]"));
        }else {  return null;}
    }
    public void clkProductImage(String productName){
        doClick(getProductImage(productName));
    }

    public WebElement getProductEyeIcon(String productName){
        if(verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::i[1]",Locator.XPath)){
            return this.driver.findElement(By.xpath("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::i[1]"));
        }else {return null;}
    }
    public void clkProductEyeIcon(String productName){
        doClick(getProductImage(productName));
    }

    @FindBys(@FindBy(how=How.XPATH, using = "//ul[contains(@id,'homefeatured')]/li/descendant::a[@class='product-name']"))
    List<WebElement> AllProductNames;
    public List<WebElement> getAllProductNames(){
        if (verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li/descendant::a[@class='product-name']", Locator.XPath)) {
            return this.AllProductNames; } else { return null; }
    }

    public List<WebElement> getProductPrice(String productName){
        if(verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName.toString().trim()+"')]/ancestor::div[2]/descendant::span[@class='price product-price'][2]",Locator.XPath)){
            return this.driver.findElements(By.xpath("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::span[@class='price product-price'][2]"));
        }else {return null;}
    }

    public WebElement clkAddToCart(String productName,String productPrice){
        if(verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[1]/descendant::span[contains(text(),'"+productPrice+"')]/ancestor::div[1]/following-sibling::div/descendant::span[contains(text(),'Add to cart')]",Locator.XPath)){
            return this.driver.findElement(By.xpath("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[1]/descendant::span[contains(text(),'"+productPrice+"')]/ancestor::div[1]/following-sibling::div/descendant::span[contains(text(),'Add to cart')]"));
        }else {return null;}
    }

    public WebElement getBtnMore(String productName){
        if(verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::span[5]",Locator.XPath)){
            return this.driver.findElement(By.xpath("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::span[5]"));
        }else {return null;}
    }

    public PageProductDetails clkBtnMore(String productName){
        doClick(getBtnMore(productName));
        return new PageProductDetails(this.driver);
    }



    public WebElement getOldProductPrize(String productName){
        if(verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::span[@class='old-price product-price'][2]",Locator.XPath)){
            return this.driver.findElement(By.xpath("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::span[@class='old-price product-price'][2]"));
        }else {return null;}
    }

    public WebElement getPercentageOfReduction(String productName){
        if(verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::span[@class='price-percent-reduction'][2]",Locator.XPath)){
            return this.driver.findElement(By.xpath("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::span[@class='price-percent-reduction'][2]"));
        }else {return null;}
    }

    public WebElement getOldPriceOfProduct(String productName){
        if(verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::span[@class='old-price product-price'][2]",Locator.XPath)){
            return this.driver.findElement(By.xpath("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::span[@class='old-price product-price'][2]"));
        }else {return null;}
    }

    //Product view Page.............................

    @FindBys(@FindBy(how=How.XPATH, using = "//div[contains(@id,'thumbs_list')]/descendant::li"))
    List<WebElement> ProductThumbsList;
    public List<WebElement> getProductThumbsList(){
        if (verifyPresentOfElement("//div[contains(@id,'thumbs_list')]/descendant::li", Locator.XPath)) {
            return this.ProductThumbsList; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@id,'view_scroll_left')]")
    private WebElement btnViewScrollLeft;
    public WebElement getBtnViewScrollLeft() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@id,'view_scroll_left')]", Locator.XPath)) {
            return this.btnViewScrollLeft; } else { return null; } }

    public void clkBtnViewScrollLeft()throws TimeoutException,NullPointerException {
        doClick(getBtnViewScrollLeft());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@id,'view_scroll_right')]")
    private WebElement BtnViewScrollRight;
    public WebElement getBtnViewScrollRight() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@id,'view_scroll_right')]", Locator.XPath)) {
            return this.BtnViewScrollRight; } else { return null; }
    }
    public void clkBtnViewScrollRight()throws TimeoutException,NullPointerException {
        doClick(getBtnViewScrollRight());
    }

    @FindBy(how = How.XPATH, using = "//span[contains(@id,'view_full_size')]/img[1]")
    private WebElement BtnViewFullSize;
    public WebElement getBtnViewFullSize() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'view_full_size')]/img[1]", Locator.XPath)) {
            return this.BtnViewFullSize; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(@itemprop,'name')]")
    private WebElement ProductName;
    public WebElement getProductName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h1[contains(@itemprop,'name')]", Locator.XPath)) {
            return this.ProductName; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Model ')]/following-sibling::span[1]")
    private WebElement ModelName;
    public WebElement getModelName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//label[contains(text(),'Model ')]/following-sibling::span[1]", Locator.XPath)) {
            return this.ModelName; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Condition ')]/following-sibling::span[1]")
    private WebElement ConditionName;
    public WebElement getConditionName() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//label[contains(text(),'Condition ')]/following-sibling::span[1]", Locator.XPath)) {
            return this.ConditionName; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'short_description_content')]/p[1]")
    private WebElement ProductDescription;
    public WebElement getProductDescription() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//div[contains(@id,'short_description_content')]/p[1]", Locator.XPath)) {
            return this.ProductDescription; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-default btn-twitter')]")
    private WebElement BtnTwitter;
    public WebElement getBtnTwitter() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@class,'btn btn-default btn-twitter')]", Locator.XPath)) {
            return this.BtnTwitter; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-default btn-facebook')]")
    private WebElement BtnFacebook;
    public WebElement getBtnFacebook() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@class,'btn btn-default btn-facebook')]", Locator.XPath)) {
            return this.BtnFacebook; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-default btn-google-plus')]")
    private WebElement BtnGooglePlus;
    public WebElement getBtnGooglePlus() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@class,'btn btn-default btn-google-plus')]", Locator.XPath)) {
            return this.BtnGooglePlus; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-default btn-pinterest')]")
    private WebElement BtnPinterest;
    public WebElement getBtnPinterest() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@class,'btn btn-default btn-pinterest')]", Locator.XPath)) {
            return this.BtnPinterest; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//span[contains(@id,'our_price_display')]")
    private WebElement ProductPrice;
    public WebElement getProductPrice() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'our_price_display')]", Locator.XPath)) {
            return this.ProductPrice; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'quantity_wanted')]")
    private WebElement txtQuantityCount;
    public WebElement gettxtQuantityCount() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@id,'quantity_wanted')]", Locator.XPath)) {
            return this.txtQuantityCount; } else { return null; }
    }
    public void passProductQuantity(Integer productCount){
        doSendKeys(gettxtQuantityCount(),String.valueOf(productCount));
    }

    @FindBy(how = How.XPATH, using = "//i[contains(@class,'icon-minus')]")
    private WebElement btnProductMinus;
    public WebElement getBtnProductMinus() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//i[contains(@class,'icon-minus')]", Locator.XPath)) {
            return this.btnProductMinus; } else { return null; }
    }
    public void clkBtnProductMinus() throws TimeoutException,NullPointerException{
        doClick(getBtnProductMinus());
    }

    @FindBy(how = How.XPATH, using = "//i[contains(@class,'icon-plus')]")
    private WebElement btnProductPlus;
    public WebElement getBtnProductPlus() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//i[contains(@class,'icon-plus')]", Locator.XPath)) {
            return this.btnProductPlus; } else { return null; }
    }
    public void clkBtnProductPlus() throws TimeoutException,NullPointerException{
        doClick(getBtnProductPlus());
    }

    @FindBy(how = How.XPATH, using = "//select[contains(@id,'group_1')]")
    private WebElement ddProductSize;
    public WebElement getDDProductSize() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//select[contains(@id,'group_1')]", Locator.XPath)) {
            return this.ddProductSize; } else { return null; } }
    public void selectProductSize(String size){
        this.dropdownHandleUtil.selectValue(getDDProductSize(),size);
    }

    @FindBys(@FindBy(how = How.XPATH, using = "//ul[contains(@id,'color_to_pick_list')]/li"))
    private List<WebElement> ProductColorList;
    public List<WebElement> getProductColorList() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//ul[contains(@id,'color_to_pick_list')]/li", Locator.XPath)) {
            return this.ProductColorList; } else { return null; }
    }

    @FindBys(@FindBy(how = How.XPATH, using = "//ul[contains(@id,'color_to_pick_list')]/li/a"))
    private List<WebElement> ProductColors;
    public WebElement getProductColor(String productColor) throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        WebElement Temp=null;
        if (verifyPresentOfElement("//span[contains(@id,'our_price_display')]", Locator.XPath)) {
            for(int i=0;i<ProductColors.size();i++){
                if(ProductColors.get(i).getAttribute("name").equals(productColor)){
                    Temp=ProductColors.get(i);
                    break; }}
            if(Temp!=null){
                return Temp;
            }else{
                return null; }
        } else { return null; }
    }

    public void SelectProductColor(String productColor) throws TimeoutException,NullPointerException {
        WebElement Temp=null;
        if (verifyPresentOfElement("//span[contains(@id,'our_price_display')]", Locator.XPath)) {
            for(int i=0;i<ProductColors.size();i++){
                if(ProductColors.get(i).getAttribute("name").equals(productColor)){
                    Temp=ProductColors.get(i);
                    break; }}
            if(Temp!=null){
                doClick(Temp);
            }}
    }


    @FindBy(how = How.XPATH, using = "//button[contains(@name,'Submit')]")
    private WebElement btnAddToCart;
    public WebElement getbtnAddToCart() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//button[contains(@name,'Submit')]", Locator.XPath)) {
            return this.btnAddToCart; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@id,'wishlist_button')]")
    private WebElement btnAddToWishList;
    public WebElement getbtnAddToWishList() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@id,'wishlist_button')]", Locator.XPath)) {
            return this.btnAddToWishList; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Close')]")
    private WebElement btnClose;
    public WebElement getbtnClose() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@title,'Close')]", Locator.XPath)) {
            return this.btnClose; } else { return null; }
    }

    //Add to card page view.

    @FindBy(how = How.XPATH, using = "//i[contains(@class,'icon-ok')]/ancestor::h2[1]")
    private WebElement lblProductSuccessfullyAddedYourShoppingCartFromCartView;
    public WebElement getLblProductSuccessfullyAddedYourShoppingCartFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//i[contains(@class,'icon-ok')]/ancestor::h2[1]", Locator.XPath)) {
            return this.lblProductSuccessfullyAddedYourShoppingCartFromCartView; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Total products')]/following-sibling::span[1]")
    private WebElement totalProductPriceFromCartView;
    public WebElement getTotalProductPriceFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//strong[contains(text(),'Total shipping')]/following-sibling::span[1]", Locator.XPath)) {
            return this.totalProductPriceFromCartView; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Total shipping')]/following-sibling::span[1]")
    private WebElement totalShippingPriceFromCartView;
    public WebElement getTotalShippingPriceFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//strong[contains(text(),'Total shipping')]/following-sibling::span[1]", Locator.XPath)) {
            return this.totalShippingPriceFromCartView; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Total shipping')]/ancestor::div[1]/following-sibling::div/strong[contains(text(),'Total')]/following-sibling::span[1]")
    private WebElement totalPrice;
    public WebElement getTotalPrice() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//strong[contains(text(),'Total shipping')]/ancestor::div[1]/following-sibling::div/strong[contains(text(),'Total')]/following-sibling::span[1]", Locator.XPath)) {
            return this.totalPrice; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//span[contains(@id,'layer_cart_product_title')]")
    private WebElement ProductNameFromCartView;
    public WebElement getProductNameFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'layer_cart_product_title')]", Locator.XPath)) {
            return this.ProductNameFromCartView; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//span[contains(@id,'layer_cart_product_attributes')]")
    private WebElement ProductColorFromCartView;
    public WebElement getProductColorFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'layer_cart_product_attributes')]", Locator.XPath)) {
            return this.ProductColorFromCartView; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//span[contains(@id,'layer_cart_product_attributes')]")
    private WebElement ProductSizeFromCartView;
    public WebElement getProductSizeFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'layer_cart_product_attributes')]", Locator.XPath)) {
            return this.ProductSizeFromCartView; } else { return null; }
    }


    @FindBy(how = How.XPATH, using = "//span[contains(@id,'layer_cart_product_price')]")
    private WebElement ProductTotalPriceFromCartView;
    public WebElement getProductTotalPriceFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'layer_cart_product_price')]", Locator.XPath)) {
            return this.ProductTotalPriceFromCartView; } else { return null; }
    }

    @FindBy(how = How.XPATH, using = "//span[contains(@title,'Continue shopping')]/span[1]")
    private WebElement btnContinueShoppingFromCartView;
    public WebElement getBtnContinueShoppingFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@title,'Continue shopping')]/span[1]", Locator.XPath)) {
            return this.btnContinueShoppingFromCartView; } else { return null; }
    }

    public void clkBtnContinueShoppingFromCartView() throws TimeoutException,NullPointerException{
        doClick(getBtnContinueShoppingFromCartView());
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Proceed to checkout')]/span[1]")
    private WebElement btnProceedToCheckoutFromCartView;
    public WebElement getBtnProceedToCheckoutFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(@title,'Proceed to checkout')]/span[1]", Locator.XPath)) {
            return this.btnProceedToCheckoutFromCartView; } else { return null; }
    }

    public void clkBtnProceedToCheckoutFromCartView() throws TimeoutException,NullPointerException{
        doClick(getBtnProceedToCheckoutFromCartView());
    }

    @FindBy(how = How.XPATH, using = "//span[contains(@title,'Close window')]")
    private WebElement btnCloseFromCartView;
    public WebElement getBtnCloseFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@title,'Close window')]", Locator.XPath)) {
            return this.btnCloseFromCartView; } else { return null; }
    }

    public void clkBtnCloseFromCartView() throws TimeoutException,NullPointerException{
        doClick(getBtnCloseFromCartView());
    }


//====================================================================


    public Integer getProductAvailabilityStatus(String productName, String productPrice)throws TimeoutException, NotFoundException,NullPointerException {
        Integer statusFlag=0;
        try{
        if (verifyPresentOfElement("//ul[contains(@id,'homefeatured')]/li/descendant::a[contains(text(),'"+productName+"')]/ancestor::div[2]/descendant::span[@class='price product-price'][contains(text(),'"+productPrice+"')][2]", Locator.XPath)) {
            return statusFlag=1; } }catch (NoSuchElementException noSuchElementException){
            noSuchElementException.printStackTrace();
            statusFlag=0;
        }return  statusFlag;
    }















}
