package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageAuthentication extends PageBase{
    public WebDriver driver;
    public PageAuthentication(WebDriver webDriver){
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Authentication')]")
    private WebElement lblAuthentication;

    public WebElement getLblAuthentication() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//span[contains(text(),'Authentication')]", Locator.XPath)) {
            return this.lblAuthentication;
        } else { return null; }
    }
}
