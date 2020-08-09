package com.qa.testutil;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

public class ScreenshotUtil {

    public WebDriver driver;
    private TakesScreenshot takesScreenshot;
    private Robot robot;
    private File sourceFileOfScreenshot;
    private File destinationFileOfScreenshot;

    public ScreenshotUtil(WebDriver driver){
        try {
            this.driver = driver;
            this.takesScreenshot = (TakesScreenshot) driver;
            this.robot = new Robot();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public String takeScreenShot(String methodName){
        String fileName=getScreenshotName(methodName);
        String directory=System.getProperty("user.dir")+"/screenshots/";
        new File(directory).mkdirs();
        String path=directory+fileName;
        try{
          File screenshot=this.takesScreenshot.getScreenshotAs(OutputType.FILE);
          System.out.println("j"+path);
          FileUtils.copyFile(screenshot,new File(path));
        }catch (Exception ae){
            ae.printStackTrace();
        }
        return path;
    }

     public String getScreenshotName(String methodName){
         Date date=new Date();
         return methodName+"_"+date.toString().replace(":","_").replace(" ","_")+".png";
     }




    public String takeScreenShotOfEntireScreen(String testStepName){
        String temporaryPath="";
        Rectangle screenSize;
        BufferedImage bufferedImage;
        try{
           screenSize=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
           bufferedImage=this.robot.createScreenCapture(screenSize);
           temporaryPath="./screenshots"+testStepName+System.currentTimeMillis()+".png";
           this.destinationFileOfScreenshot=new File(temporaryPath);
            ImageIO.write(bufferedImage,"png",this.destinationFileOfScreenshot);
        }catch (Exception ae){
            ae.printStackTrace();
        }return temporaryPath;
    }

    public String getScreenShotOfElement(WebElement element,String testStepName){
        String temporaryPath="";
        try{
            this.sourceFileOfScreenshot=element.getScreenshotAs(OutputType.FILE);
            temporaryPath="./screenshots"+testStepName+System.currentTimeMillis()+".png";
            this.destinationFileOfScreenshot=new File(temporaryPath);
            FileHandler.copy(this.sourceFileOfScreenshot,this.destinationFileOfScreenshot);
        }catch (Exception ae){
            ae.printStackTrace();
        }return temporaryPath;
    }






}
