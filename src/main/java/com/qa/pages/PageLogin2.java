package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageLogin2 extends PageBase{

    public WebDriver driver;
    public PageLogin2(WebDriver driver) {
        super(driver);
        try { this.driver = driver;
            PageFactory.initElements(this.driver, this);
        } catch (Exception ae) {
            ae.printStackTrace(); }
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'email_input')]")
    private WebElement txtUsername;
    public WebElement getTxtUsername() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@id,'email_input')]", Locator.XPath)) {
            return this.txtUsername; } else { return null; }
    }

    public void passUsername(String username){
        doSendKeys(getTxtUsername(),username);
    }


    @FindBy(how = How.XPATH, using = "//input[contains(@id,'password_input')]")
    private WebElement txtPassword;
    public WebElement getTxtPassword() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@id,'password_input')]", Locator.XPath)) {
            return this.txtPassword; } else { return null; }
    }

    public void passPassword(String password){
        doSendKeys(getTxtPassword(),password);
    }


    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Log In')]")
    private WebElement btnSignIN;
    public WebElement getBtnSignIN() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(text(),'Log In')]", Locator.XPath)) {
            return this.btnSignIN; } else { return null; }
    }

   public void clkBtnSignIn(){
        doClick(getBtnSignIN());
   }












}
