package com.qa.pageutil;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSHandleUtil {
    public WebDriver driver;
    public JavascriptExecutor javascriptExecutor;
    public JSHandleUtil(WebDriver driver){
        try{
            this.driver=driver;
            this.javascriptExecutor=(JavascriptExecutor)driver;
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void doClickElement(WebElement element){
        try{
            this.javascriptExecutor.executeScript("arguments[0].click();",element);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void doSendKeys(WebElement element,String value){
        try{
            this.javascriptExecutor.executeScript("arguments[0].setAttribute('value','"+value+"');",element);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void doScrollBy(int verticalScrollAxes,int horizontalScrollAxes){
        try{
          this.javascriptExecutor.executeScript("window.scrollBy("+verticalScrollAxes+","+horizontalScrollAxes+")");
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void doScrollTo(int verticalScrollAxes,int horizontalScrollAxes){
        try{
            this.javascriptExecutor.executeScript("window.scrollTo("+verticalScrollAxes+","+horizontalScrollAxes+")");

        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void doScroll(int verticalScrollAxes,int horizontalScrollAxes){
        try{
            this.javascriptExecutor.executeScript("window.scroll("+verticalScrollAxes+","+horizontalScrollAxes+")");
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void doScrollByWebElement(WebElement element){
        try{
            this.javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }



    public void doScrollPageByPage(){
        try{
            long pageHeight=(long)this.javascriptExecutor.executeScript("return window.InnerHeight");
            long scrollHeight=(long)this.javascriptExecutor.executeScript("return.document.body.scrollHeight");
            int numberOfPages=(int)(scrollHeight/pageHeight)+1;
            try {
                for(int i=0;i<numberOfPages;i++) {
                    this.javascriptExecutor.executeScript("window.scrollBy(0,"+pageHeight+")");
                }}catch (Exception ae) {
                ae.printStackTrace();
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }


    public Double getPageYOffSet(){
            return Double.parseDouble(javascriptExecutor.executeScript("return window.pageYOffset;").toString());
    }

    public Double getPageXOffset(){
        return Double.parseDouble(javascriptExecutor.executeScript("return window.pageXOffset;").toString());

    }










}
