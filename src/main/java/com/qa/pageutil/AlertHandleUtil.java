package com.qa.pageutil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHandleUtil {

    public WebDriver driver;
    public Alert alert;
    public AlertHandleUtil(WebDriver driver){
        try{
            this.driver=driver;
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public Alert moveToAlert(){
        try{
            this.driver.switchTo().alert();
        }catch (Exception ae){
            ae.printStackTrace();
        }return this.alert;
    }

    public void dismissAlert(){
        try{
            this.alert.dismiss();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void acceptAlert(){
        try{
            this.alert.accept();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public String getTextOfAlert(){
        String alertText="";
        try{
            alertText=this.alert.getText();
        }catch (Exception ae){
            ae.printStackTrace();
        }return alertText;
    }

    public void sendValuesOfAlert(String value){
        try{
            this.alert.sendKeys(value);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }


















}
