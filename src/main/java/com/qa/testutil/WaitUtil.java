package com.qa.testutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUtil {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private FluentWait fluentWait;
    public WaitUtil(WebDriver driver,int waitTime){
        this.driver=driver;
        this.webDriverWait=new WebDriverWait(driver, waitTime);
    }


    public void setSleepTime(int sleepTime){
        try{
            Thread.sleep(sleepTime);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void setImplicitWait(int implicitWaitTime){
        try{
            this.driver.manage().timeouts().implicitlyWait(implicitWaitTime,TimeUnit.SECONDS);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void setExplicitWait(WebDriver driver,int explicitWaitTime){
        try{
            this.webDriverWait=new WebDriverWait(driver,explicitWaitTime);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public WebDriverWait getWebDriverWait(){
        WebDriverWait webDriverWait=null;
        try{
            webDriverWait=this.webDriverWait;
        }catch (Exception ae){
            ae.printStackTrace();
        }return webDriverWait;
    }






}
