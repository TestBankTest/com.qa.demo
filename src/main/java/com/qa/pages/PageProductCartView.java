package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageProductCartView extends PageBase{

    public WebDriver driver;
    public PageProductCartView(WebDriver driver) {
        super(driver);
        try { this.driver = driver;
            PageFactory.initElements(this.driver, this);
        } catch (Exception ae) {
            ae.printStackTrace(); }
    }

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

    @FindBy(how = How.XPATH, using = "//span[contains(@id,'layer_cart_product_quantity')]")
    private WebElement ProductQuantityFromCartView;
    public WebElement getProductQuantityFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'layer_cart_product_quantity')]", Locator.XPath)) {
            waitUtil.executeSleepWait(this.ProductQuantityFromCartView);
            return this.ProductQuantityFromCartView;
        } else { return null; }
    }
    public String getProductQuantity(){
       return doGetText(getProductQuantityFromCartView());
    }

    @FindBy(how = How.XPATH, using = "//span[contains(@id,'layer_cart_product_attributes')]")
    private WebElement ProductColorFromCartView;
    public WebElement getProductColorFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'layer_cart_product_attributes')]", Locator.XPath)) {
            waitUtil.executeSleepWait(this.ProductColorFromCartView);
            return this.ProductColorFromCartView;
        } else { return null; }
    }
    public String getProductColor(){
        return doGetText(getProductSizeFromCartView()).split(",")[0].trim();
    }


    @FindBy(how = How.XPATH, using = "//span[contains(@id,'layer_cart_product_attributes')]")
    private WebElement ProductSizeFromCartView;
    public WebElement getProductSizeFromCartView() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'layer_cart_product_attributes')]", Locator.XPath)) {
            waitUtil.executeSleepWait(this.ProductSizeFromCartView);
            return this.ProductSizeFromCartView;
        } else { return null; }
    }
    public String getProductSize(){
        return doGetText(getProductSizeFromCartView()).split(",")[1].trim();
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







}
