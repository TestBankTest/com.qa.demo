package com.qa.pageutil;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandleUtil {

    public WebDriver driver;
    public WindowHandleUtil(WebDriver driver){
        try{
            this.driver=driver;
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public String getCurrentWindowName(){
        String currentWindowName="";
        try{
            currentWindowName=this.driver.getWindowHandle();
        }catch (Exception ae){
            ae.printStackTrace();
        }return currentWindowName;
    }

    public Set<String> getAllWindowNames(){
        Set<String>AllWindowsNames=null;
        try{
            AllWindowsNames=this.driver.getWindowHandles();
        }catch (Exception ae){
            ae.printStackTrace();
        }return AllWindowsNames;
    }

    public void moveToWindow(String windowName,String pageUrl){
        Set<String> windowNames=null;
        try{
            windowNames=getAllWindowNames();
            Iterator itr=windowNames.iterator();
            while(itr.hasNext()){
                this.driver.switchTo().window(itr.next().toString());
                if(this.driver.getCurrentUrl().equals(pageUrl)){
                    break;
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }







}
