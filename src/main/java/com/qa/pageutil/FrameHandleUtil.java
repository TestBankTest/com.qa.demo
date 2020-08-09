package com.qa.pageutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandleUtil {

    public WebDriver driver;
    public FrameHandleUtil(WebDriver driver){
        try{
            this.driver=driver;
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void moveToFrameByFrameIndex(int index){
        try{
            this.driver.switchTo().frame(index);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void moveToFrameByFrameName(String frameName){
        try{
            this.driver.switchTo().frame(frameName);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void moveToFrameByFrameWebElement(WebElement frameElement){
        try{
            this.driver.switchTo().frame(frameElement);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void moveToParentFrame(){
        try{
            this.driver.switchTo().parentFrame();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void moveToParentWindow(){
        try{
            this.driver.switchTo().defaultContent();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }


}
