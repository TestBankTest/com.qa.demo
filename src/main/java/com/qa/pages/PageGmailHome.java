package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageGmailHome extends PageBase {

    public WebDriver driver;

    public PageGmailHome(WebDriver driver) {
        super(driver);
        try {
            this.driver = driver;
            PageFactory.initElements(this.driver, this);
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Inbox')]")
    private WebElement lblInbox;
    public WebElement getLblInbox() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//a[contains(text(),'Inbox')]", Locator.XPath)) {
            return this.lblInbox; } else { return null; }
    }
    public void clkLblInbox()throws TimeoutException,NullPointerException {
        doClick(getLblInbox());
    }
/*
    @FindBy(how = How.XPATH, using = "//td/descendant::span[contains(text(),'Complete your Asana sign up')]/ancestor::td[1]")
    private WebElement lblCompleteYourAsanaignUp;
    public WebElement getlblCompleteYourAsanaignUp() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//td/descendant::span[contains(text(),'Complete your Asana sign up')]/ancestor::td[1]", Locator.XPath)) {
            return this.lblCompleteYourAsanaignUp; } else { return null; }
    }
    public void clklblCompleteYourAsanaignUp()throws TimeoutException,NullPointerException {
        doClick(getlblCompleteYourAsanaignUp());
    }
  */

    @FindBy(how = How.XPATH, using = "//td/descendant::span[contains(text(),'Asana')]/ancestor::td[1]/following-sibling::td/descendant::span[contains(text(),'Complete your Asana sign up')]/ancestor::tr[1]")
    private WebElement lblCompleteYourAsanaignUp;
    public WebElement getlblCompleteYourAsanaignUp() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//td/descendant::span[contains(text(),'Asana')]/ancestor::td[1]/following-sibling::td/descendant::span[contains(text(),'Complete your Asana sign up')]/ancestor::tr[1]", Locator.XPath)) {
            return this.lblCompleteYourAsanaignUp; } else { return null; }
    }
    public void clklblCompleteYourAsanaignUp()throws TimeoutException,NullPointerException {
        doClick(getlblCompleteYourAsanaignUp());
    }




    @FindBys(@FindBy(how=How.XPATH, using = "//span[contains(text(),'Verify email address')]"))
    List<WebElement> lblVerifyEmailAddress;
    public List<WebElement> getLblVerifyEmailAddress(){
        if (verifyPresentOfElement("//span[contains(text(),'Verify email address')]", Locator.XPath)) {
            return this.lblVerifyEmailAddress; } else { return null; }
    }

    public void clickVerifyEmailAddress(){
        doClick(getLblVerifyEmailAddress().get(1));
    }






















}
