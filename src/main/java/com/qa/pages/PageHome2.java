package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageHome2 extends PageBase{


    public WebDriver driver;
    public PageHome2(WebDriver driver) {
        super(driver);
        try { this.driver = driver;
            PageFactory.initElements(this.driver, this);
        } catch (Exception ae) {
            ae.printStackTrace(); }
    }

    @FindBy(how = How.XPATH, using = "//h3[contains(text(),'Your work manager. But better.')]/ancestor::div[1]/descendant::a[1]")
    private WebElement btnTryForFree;
    public WebElement getBtnTryForFree() throws NoSuchElementException, TimeoutException, NotFoundException,NullPointerException {
        if (verifyPresentOfElement("//h3[contains(text(),'Your work manager. But better.')]/ancestor::div[1]/descendant::a[1]", Locator.XPath)) {
            return this.btnTryForFree; } else { return null; }
    }
    public void clkBtnTryForFree()throws TimeoutException,NullPointerException {
        doClick(getBtnTryForFree());
    }







}
