package com.qa.testutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadFileUtil {

    public WebDriver driver;
    public UploadFileUtil(WebDriver driver){
        try{
            this.driver=driver;
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void uploadFile(WebElement element,String filePath){
        try{
            element.sendKeys(filePath);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }



}
