package com.qa.pages;

import com.qa.base.Base;
import com.qa.browserfactory.WebdriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageSignIn extends PageBase{

    public WebDriver driver;
    public PageSignIn(WebDriver webDriver){
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(this.driver,this);
    }


        @FindBy(how = How.XPATH, using = "//span[contains(text(),'Authentication')]")
        private WebElement lblAuthentication;
        public WebElement getLblAuthentication() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
            if (verifyPresentOfElement("//span[contains(text(),'Authentication')]", Locator.XPath)) {
                return this.lblAuthentication; } else { return null; }
        }

        @FindBy(how = How.XPATH, using = "//input[contains(@id,'email_create')]")
        private WebElement txtEmailAddress;
        public WebElement getTxtEmailAddress() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
            if (verifyPresentOfElement("//input[contains(@id,'email_create')]", Locator.XPath)) {
                return this.txtEmailAddress; } else { return null; }
        }

        public void passEmailAddress(String emailAddress){
            doSendKeys(getTxtEmailAddress(),emailAddress);
        }

        @FindBy(how = How.XPATH, using = "//button[contains(@id,'SubmitCreate')]")
        private WebElement btnCreateAccount;
        public WebElement getBtnCreateAccount() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
            if (verifyPresentOfElement("//button[contains(@id,'SubmitCreate')]", Locator.XPath)) {
                return this.btnCreateAccount; } else { return null; }
        }

        public PageAuthentication clkBtnCreateAccount(WebDriver driver)throws TimeoutException,NullPointerException {
            doClick(getBtnCreateAccount());
            return new PageAuthentication(driver);
        }

        @FindBy(how = How.XPATH, using = "//label[contains(text(),'Password')]/ancestor::div[1]/preceding-sibling::div/input[1]")
        private WebElement txtEmailAddressTwo;

        public WebElement getTxtEmailAddressTwo() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
                if (verifyPresentOfElement("//label[contains(text(),'Password')]/ancestor::div[1]/preceding-sibling::div/input[1]", Locator.XPath)) {
                    return this.txtEmailAddressTwo;
                } else {
                    return null;
                }
            }

            public void passEmailAddressTwo(String emailAddress) {
                doSendKeys(getTxtEmailAddressTwo(), emailAddress);
            }

            @FindBy(how = How.XPATH, using = "//input[contains(@id,'passwd')]")
            private WebElement txtPassword;

            public WebElement getTxtPassword() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
                if (verifyPresentOfElement("//input[contains(@id,'passwd')]", Locator.XPath)) {
                    return this.txtPassword;
                } else {
                    return null;
                }
            }

            public void passEmailPassword(String emailPassword) {
                doSendKeys(getTxtPassword(), emailPassword);
            }

            @FindBy(how = How.XPATH, using = "//a[contains(text(),'Forgot your password?')]")
            private WebElement lnkLblForgotYourPassword;

            public WebElement getLnlLblForgotYourPassword() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
                if (verifyPresentOfElement("//a[contains(text(),'Forgot your password?')]", Locator.XPath)) {
                    return this.lnkLblForgotYourPassword;
                } else {
                    return null;
                }
            }

            public PageForgotYourPassword clkLnkLblForgotYourPassword(WebDriver driver) throws TimeoutException, NullPointerException {
                doClick(getLnlLblForgotYourPassword());
                return new PageForgotYourPassword(driver);
            }

            @FindBy(how = How.XPATH, using = "//button[contains(@id,'SubmitLogin')]")
            private WebElement btnSignIn;

            public WebElement getBtnSignIn() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
                if (verifyPresentOfElement("//button[contains(@id,'SubmitLogin')]", Locator.XPath)) {
                    return this.btnSignIn;
                } else {
                    return null;
                }
            }

            public PageAddress clkBtnSignIn(WebDriver driver) throws TimeoutException, NullPointerException {
                doClick(getBtnSignIn());
                return new PageAddress(driver);
            }


            @FindBy(how = How.XPATH, using = "//button[contains(@id,'SubmitCreate')]")
            private WebElement btnCreateAccountTwo;

            public WebElement getBtnCreateAccountTwo() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
                if (verifyPresentOfElement("//button[contains(@id,'SubmitCreate')]", Locator.XPath)) {
                    return this.btnCreateAccount;
                } else {
                    return null;
                }
            }

            public void clkBtnCreateAccountTwo() throws TimeoutException, NullPointerException {
                doClick(getBtnCreateAccount());
            }

            //alert message...............

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'An email address required.')]")
    private WebElement alertAnEmailAddressRequired;

    public WebElement getAlertAnEmailAddressRequired() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//li[contains(text(),'An email address required.')]", Locator.XPath)) {
            return this.alertAnEmailAddressRequired;
        } else { return null; }
    }
    public List<WebElement>getAvailabilityStatusOfAlertAnEmailAddressRequired(){
        return driver.findElements(By.xpath("//li[contains(text(),'An email address required.')]"));
    }


    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Authentication failed.')]")
    private WebElement alertAuthenticationFailed;

    public WebElement getAlertAuthenticationFailed() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//li[contains(text(),'Authentication failed.')]", Locator.XPath)) {
            return this.alertAuthenticationFailed;
        } else { return null; }
    }
    public List<WebElement>getAvailabilityStatusOfAlertAuthenticationFailed(){
        return driver.findElements(By.xpath("//li[contains(text(),'Authentication failed.')]"));
    }


    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Invalid email address.')]")
    private WebElement alertInvalidEmailAddress;

    public WebElement getAlertInvalidEmailAddress() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//li[contains(text(),'Invalid email address.')]", Locator.XPath)) {
            return this.alertInvalidEmailAddress;
        } else { return null; }
    }
    public List<WebElement>getAvailabilityStatusOfAlertInvalidEmailAddress(){
        return driver.findElements(By.xpath("//li[contains(text(),'Invalid email address.')]"));
    }

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Password is required.')]")
    private WebElement alertPasswordIsRequired;

    public WebElement getAlertPasswordIsRequired() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//li[contains(text(),'Password is required.')]", Locator.XPath)) {
            return this.alertPasswordIsRequired;
        } else { return null; }
    }
    public List<WebElement>getAvailabilityStatusOfAlertPasswordIsRequired(){
        return driver.findElements(By.xpath("//li[contains(text(),'Password is required.')]"));
    }


    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Please enter your email address to create an account.')]/ancestor::div[1]/descendant::li[1]")
    private WebElement alertEmailAddressAlreadyUsed;

    public WebElement getAlertEmailAddressAlreadyUsed() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//p[contains(text(),'Please enter your email address to create an account.')]/ancestor::div[1]/descendant::li[1]", Locator.XPath)) {
            return this.alertEmailAddressAlreadyUsed;
        } else { return null; }
    }

    public List<WebElement>getAvailabilityStatusOfAlertEmailAddressAlreadyUsed(){
        return driver.findElements(By.xpath("//p[contains(text(),'Please enter your email address to create an account.')]/ancestor::div[1]/descendant::li[1]"));
    }











}
