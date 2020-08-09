package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FinalPage extends PageBase{

    public WebDriver driver;
    public FinalPage(WebDriver driver) {
        super(driver);
        try { this.driver = driver;
            PageFactory.initElements(this.driver, this);
        } catch (Exception ae) {
            ae.printStackTrace(); }
    }


    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Welcome')]/ancestor::div[1]/descendant::span[1]")
    private WebElement lblEmailID;
    public WebElement getLblEmailID() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h2[contains(text(),'Welcome')]/ancestor::div[1]/descendant::span[1]", Locator.XPath)) {
            return this.lblEmailID; } else { return null; }
    }





}
