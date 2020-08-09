package com.qa.pageutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownHandleUtil {
    public WebDriver driver;
    public Select select;
    public DropdownHandleUtil(WebDriver driver){
        try {
            this.driver = driver;
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void selectValue(WebElement element, String value){
        try{
            this.select=new Select(element);
            List<WebElement> options=select.getOptions();
            for(int i=0;i<options.size();i++){
                if(options.get(i).getText().trim().equals(value)){
                    options.get(i).click();
                }
            }
        }catch(Exception ae){
            ae.printStackTrace();
        }
    }

    private Select setSelect(WebElement element){
        try{
            this.select=new Select(element);
        }catch (Exception ae){
            ae.printStackTrace();
        }return this.select;
    }

    public void selectByIndex(WebElement element,int index){
        try{
          setSelect(element).selectByIndex(index);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void selectByValue(WebElement element,String value){
        try{
            setSelect(element).selectByValue(value);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }



















}
