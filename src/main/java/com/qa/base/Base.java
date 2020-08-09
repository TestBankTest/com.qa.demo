package com.qa.base;

import com.qa.browserfactory.WebdriverManager;
import com.qa.pageutil.*;
import com.qa.testconfigurationutil.ConfigurationFilesName;
import com.qa.testconfigurationutil.PropertyNames;
import com.qa.testconfigurationutil.TestConfigurationFileUtil;
import com.qa.testutil.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    /* In Base class declare all page and test utility and will be initialized
       into Test Base class and this base will extent by PageBase class and TestBase
       class, So all those common utility can be used into both page and testcase classes.

       Base Class--->Page class = All page class can be used both page and test utility.
       Base Class--->Test Base--->Test Case Classes = All test case class can be used all test utility.

       In here, We defined All utility class objects/references with their configure method which is
       used to initialized those objects and we called configure method into base class.
    */

    //======================================Web Driver configuration==========================================//
    public static WebDriver driver;
    protected WebdriverManager webdriverManager;
    public static WebDriverWait webDriverWait;
    public static Logger logger;
    private PropertyNames propertyNames;
    //========================================================================================================//

    //=====================================Configure Page Utility=============================================//
    public AlertHandleUtil alertHandleUtil;
    public static DropdownHandleUtil dropdownHandleUtil;
    public FrameHandleUtil frameHandleUtil;
    public static JSHandleUtil jsHandleUtil;
    public static ActionsHandleUtil actionsHandleUtil;
    public WebcalenderHandleUtil webcalenderHandleUtil;
    public WebTableHandleUtil webTableHandleUtil;
    public WindowHandleUtil windowHandleUtil;
    //=========================================================================================================//

    //======================================Configure Test Utility=============================================//
    public static ScreenshotUtil screenshotUtil;
    public static TestReportUtil testReportUtil;
    public static UploadFileUtil uploadFileUtil;
    public static EmailUtil emailUtil;
    public static WaitUtil waitUtil;
    //==========================================================================================================//

    //======================================Configure Configuration File========================================//
    public static TestConfigurationFileUtil systemConfigurationFileUtil;
    public static TestConfigurationFileUtil testEnvironmentConfigurationFileUtil;
    //==========================================================================================================//


    //=======================================Define System path================================================//
    //=======================================Intialise Browser Driver==========================================//
    public void setWebDriverManager(){
        try{
           this.webdriverManager=new WebdriverManager();
           this.driver=this.webdriverManager.createDriver();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
    //============================================================================================================//

    //======================================Define Page Utility====================================================//
    public void setPageUtility(){
        try{
            this.alertHandleUtil=new AlertHandleUtil(this.driver);
            this.dropdownHandleUtil=new DropdownHandleUtil(this.driver);
            this.frameHandleUtil=new FrameHandleUtil(this.driver);
            this.jsHandleUtil=new JSHandleUtil(this.driver);
            this.actionsHandleUtil=new ActionsHandleUtil(this.driver);
            this.webcalenderHandleUtil=new WebcalenderHandleUtil(this.driver);
            this.webTableHandleUtil=new WebTableHandleUtil(this.driver);
            this.windowHandleUtil=new WindowHandleUtil(this.driver);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
    //===============================================================================================================//

    //========================================Define Test Utility=====================================================//
    public void setTestUtility(){
        try{
            this.logger=LoggerUtil.getLogger();
            emailUtil=new EmailUtil();
            this.waitUtil=new WaitUtil(this.driver,10);
            this.webDriverWait=this.waitUtil.getWebDriverWait();
            this.screenshotUtil=new ScreenshotUtil(this.driver);
            this.uploadFileUtil=new UploadFileUtil(this.driver);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
    //=================================================================================================================//

    public TestReportUtil setTestReportUtil(){
        try{
            testReportUtil=new TestReportUtil(this.driver);
        }catch (Exception ae){
            ae.printStackTrace();
        }return testReportUtil;
    }





    //=========================Configure Configuration Files===========================================================//
    public void setConfigurationFile(){
        try{
            this.systemConfigurationFileUtil=new TestConfigurationFileUtil("./configurationFiles/SystemConfigurationInfo.properties", ConfigurationFilesName.SystemConfigurationInfoFile);
            this.testEnvironmentConfigurationFileUtil=new TestConfigurationFileUtil("./configurationFiles/TestEnvironmentConfiguration.properties",ConfigurationFilesName.TestEnvironmentConfigurationFile);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public String getPropertyName(PropertyNames propertyNames){
        String property="";
        try{
            this.propertyNames=propertyNames;
            property=this.propertyNames.getProperty();
        }catch (Exception ae){
            ae.printStackTrace();
        }return property;
    }























































}
