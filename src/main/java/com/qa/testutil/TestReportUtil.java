package com.qa.testutil;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.base.Base;
import com.qa.testconfigurationutil.ConfigurationFilesName;
import com.qa.testconfigurationutil.PropertyNames;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TestReportUtil extends Base {

    private static ExtentSparkReporter htmlReporter=null;
    private static ExtentReports extentReports=null;
    private static ExtentTest extentsTest=null;
    private File src=null;
    public WebDriver driver;
    private static String timestamp;
    String logText;
    Markup markup;
    public ConfigurationFilesName configurationFilesName;
    public MediaEntityModelProvider mediaEntityModelProvider;
    public TestReportUtil(WebDriver driver) {
        this.driver=driver;
    }

    private ExtentSparkReporter configureHtmlReporter(){
        try{
            this.src=new File("./testReports/TestReport_"+getTimestamp()+".html");
            htmlReporter=new ExtentSparkReporter(this.src);
            this.htmlReporter.config().setDocumentTitle("Demo Automation Report");
            this.htmlReporter.config().setReportName(" Web Automation Report");
            this.htmlReporter.config().setTheme(Theme.DARK);
        }catch (Exception ae){
            ae.printStackTrace();
        }return htmlReporter;
    }
    private ExtentReports configureExtentReport(){
        try{
            this.configurationFilesName=ConfigurationFilesName.SystemConfigurationInfoFile;
           extentReports=new ExtentReports();
           extentReports.attachReporter(configureHtmlReporter());
           extentReports.setSystemInfo("HostName",systemConfigurationFileUtil.getPropertyValue(this.configurationFilesName.getConfigurationFile(),getPropertyName(PropertyNames.SystemConfiguration_HostName)));
            extentReports.setSystemInfo("OperatingSystem",systemConfigurationFileUtil.getPropertyValue(this.configurationFilesName.getConfigurationFile(),getPropertyName(PropertyNames.SystemConfiguration_OperatingSystem)));
            extentReports.setSystemInfo("DepartmentName",systemConfigurationFileUtil.getPropertyValue(this.configurationFilesName.getConfigurationFile(),getPropertyName(PropertyNames.SystemConfiguration_DepartmentName)));
            extentReports.setSystemInfo("TesterName",systemConfigurationFileUtil.getPropertyValue(this.configurationFilesName.getConfigurationFile(),getPropertyName(PropertyNames.SystemConfiguration_TesterName)));
        }catch (Exception ae){
            ae.printStackTrace();
        }return extentReports;
    }

    public void setTestReport(){
        try{
            configureExtentReport();
        }catch (Exception ae){
            ae.printStackTrace();
        }


    }

    public void configureTest(String textName){
        try{
            extentsTest=extentReports.createTest(textName);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void configureTestResult(ITestResult iTestResult){
        String methodName=iTestResult.getMethod().getMethodName();
            switch (iTestResult.getStatus()){
                case ITestResult.SUCCESS:
                    String logText="<b>Test Method "+methodName+" Successful</b>";
                    Markup markup= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
                    extentsTest.log(Status.PASS,markup);
                    break;
                case ITestResult.FAILURE:
                     String exceptionMessage= Arrays.toString(iTestResult.getThrowable().getStackTrace());
                     extentsTest.fail("<details><summary><b><font color=red>Exception Occured, Click to see details:"
                     +"</font></b></summary>"+exceptionMessage.replace(",","<br>")+"</details> \n");
                     String screenshotPath=screenshotUtil.takeScreenShot(iTestResult.getMethod().getMethodName());
                     try {
                     extentsTest.fail("<b><font color=red>"+"Screenshot of failure"+"</font></b>"
                      ,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                     }catch (IOException ioException) {
                         extentsTest.fail("Test Failed, Can not attach screenshot");
                     }
                     logText="<b>Test Method "+methodName+" Failed</b>";
                     markup= MarkupHelper.createLabel(logText, ExtentColor.RED);
                     extentsTest.log(Status.FAIL,markup);
                    break;
                case ITestResult.SKIP:
                    logText="<b>Test Method "+methodName+" Skipped</b>";
                    markup= MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
                    extentsTest.log(Status.SKIP,markup);
                    break;
                default:

        }
    }

    public void flushReport(){
        try{
            extentReports.flush();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public String getTimestamp(){
        return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":", "-");
    }

   public String getTestReportFilePath(){
        return this.src.toString();
   }

















}
