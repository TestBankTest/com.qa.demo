package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageForgotYourPassword extends PageBase{
    public WebDriver driver;
    public PageForgotYourPassword(WebDriver webDriver){
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Forgot your password?')]")
    private WebElement lblForgotYourPassword;

    public WebElement getLblForgotYourPassword() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//h1[contains(text(),'Forgot your password?')]", Locator.XPath)) {
            return this.lblForgotYourPassword;
        } else { return null; }
    }



}
