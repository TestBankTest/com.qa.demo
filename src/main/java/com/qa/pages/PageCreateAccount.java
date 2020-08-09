package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageCreateAccount extends PageBase{

    public WebDriver driver;
    public PageCreateAccount(WebDriver driver) {
        super(driver);
        try { this.driver = driver;
            PageFactory.initElements(this.driver, this);
        } catch (Exception ae) {
            ae.printStackTrace(); }
    }

    @FindBys(@FindBy(how=How.XPATH, using = "//span[contains(text(),'Are you sure this address can receive email? If so, please continue.')]/preceding-sibling::input[1]"))
    List<WebElement> txtEmailID;
    public List<WebElement> getTxtEmailID(){
        if (verifyPresentOfElement("//span[contains(text(),'Are you sure this address can receive email? If so, please continue.')]/preceding-sibling::input[1]", Locator.XPath)) {
            return this.txtEmailID; } else { return null; }
    }

    public void passEmailID(String eMail){
        doSendKeys(this.txtEmailID.get(0),eMail);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Try for free')]/ancestor::div[1]/descendant::button[1]")
    private WebElement btnTryForFree;
    public WebElement getBtnTryForFree() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Try for free')]/ancestor::div[1]/descendant::button[1]", Locator.XPath)) {
            return this.btnTryForFree; } else { return null; }
    }
    public void clkBtnTryForFree()throws TimeoutException,NullPointerException {
        doClick(getBtnTryForFree());
    }










}
