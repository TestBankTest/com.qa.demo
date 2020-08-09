package com.qa.testcases;

import com.qa.pages.Locator;
import com.qa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageEmail_Test extends PageBase {

    public WebDriver driver;
    public PageEmail_Test(WebDriver driver) {
        super(driver);
        try { this.driver = driver;
            PageFactory.initElements(this.driver, this);
        } catch (Exception ae) {
            ae.printStackTrace(); }
    }

    @FindBys(@FindBy(how= How.XPATH, using = "//span[contains(text(),'Continue with Google')]"))
    List<WebElement> btnContinueWithGoogle;
    public List<WebElement> getBtnContinueWithGoogle(){
        if (verifyPresentOfElement("//span[contains(text(),'Continue with Google')]", Locator.XPath)) {
            return this.btnContinueWithGoogle; } else { return null; }
    }

    public void clkBtnContinueWithGoogle(){
        doClick(getBtnContinueWithGoogle().get(0));
    }
}
