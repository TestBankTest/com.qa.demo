package com.qa.pageutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsHandleUtil {
    public WebDriver driver;
    public Actions actions;
    public ActionsHandleUtil(WebDriver driver){
        this.driver=driver;
        this.actions=new Actions(this.driver);
    }

    public void moveElement(WebElement element){
       this.actions.moveToElement(element).build().perform();
    }

    public void moveAndClickElement(WebElement element){
       this.actions.moveToElement(element).click().build().perform();
    }







}
