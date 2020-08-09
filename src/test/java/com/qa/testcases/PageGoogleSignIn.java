package com.qa.testcases;

import com.qa.pages.Locator;
import com.qa.pages.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageGoogleSignIn extends PageBase {

    public WebDriver driver;
    public PageGoogleSignIn(WebDriver driver) {
        super(driver);
        try { this.driver = driver;
            PageFactory.initElements(this.driver, this);
        } catch (Exception ae) {
            ae.printStackTrace(); }
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'identifierId')]")
    private WebElement txtUsername;
    public WebElement getBtnUsername() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@id,'identifierId')]", Locator.XPath)) {
            return this.txtUsername; } else { return null; }
    }
    public void passUsername(String username)throws TimeoutException,NullPointerException {
        doSendKeys(getBtnUsername(),username);
    }

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]")
    private WebElement btnNext;
    public WebElement getBtnNext() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//span[contains(text(),'Next')]", Locator.XPath)) {
            return this.btnNext; } else { return null; }
    }
    public void clkBtnNext()throws TimeoutException,NullPointerException {
        doClick(getBtnNext());
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'password')]")
    private WebElement txtPassword;
    public WebElement getTxtPassword() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//input[contains(@name,'password')]", Locator.XPath)) {
            return this.txtPassword; } else { return null; }
    }
    public void passPassword(String username)throws TimeoutException,NullPointerException {
        doSendKeys(getTxtPassword(),username);
    }














}
