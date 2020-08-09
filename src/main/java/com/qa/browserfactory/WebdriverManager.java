package com.qa.browserfactory;

import com.qa.base.Base;
import com.qa.testconfigurationutil.ConfigurationFilesName;
import com.qa.testconfigurationutil.PropertyNames;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class WebdriverManager extends Base {
    private WebDriver driver;
    private String driverValue;
    private String environmentValue;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY="webdriver.chrome.driver";
    private static  String chromeDriverPath="";
    private static String firefoxDriverPath="";
    private String applicationUrl="";
    private ConfigurationFilesName configurationFilesName;
    private int implicitWaitTime;

    public WebdriverManager() {
        try{
            System.out.println("I am here in driverManager inside with " +systemConfigurationFileUtil);
            this.configurationFilesName=ConfigurationFilesName.TestEnvironmentConfigurationFile;
            environmentValue=testEnvironmentConfigurationFileUtil.getPropertyValue(this.configurationFilesName.getConfigurationFile(), getPropertyName(PropertyNames.TestEnvironmentConfiguration_TestEnvironment));
            System.out.println("enviromrnt value " +environmentValue);
            driverValue=this.testEnvironmentConfigurationFileUtil.getPropertyValue(this.configurationFilesName.getConfigurationFile(),getPropertyName(PropertyNames.TestEnvironmentConfiguration_BrowserName));
            //chromeDriverPath=this.PROJECT_PATH.concat(systemConfigurationFileUtil.getPropertyValue(this.configurationFilesName.getConfigurationFile(),PropertyNames.TestEnvironmentConfiguration_ChromeDriverPath));
            //firefoxDriverPath=this.PROJECT_PATH.concat(this.systemConfigurationFileUtil.getPropertyValue(this.configurationFilesName.getConfigurationFile(),PropertyNames.TestEnvironmentConfiguration_FirefoxDriverPath));
            this.applicationUrl=this.testEnvironmentConfigurationFileUtil.getPropertyValue(this.configurationFilesName.getConfigurationFile(),getPropertyName(PropertyNames.TestEnvironmentConfiguration_ProductionApplicationUrl));
            this.implicitWaitTime=Integer.valueOf(this.testEnvironmentConfigurationFileUtil.getPropertyValue(this.configurationFilesName.getConfigurationFile(),getPropertyName(PropertyNames.TestEnvironmentConfiguration_ImplicitWaitTimeOut)));
            configureDriverType(driverValue);
            configureEnvironmentType(environmentValue);
        }catch(Exception ae){
            ae.printStackTrace();
        }
    }

    private void configureDriverType(String driverValue){
        switch(driverValue){
            case "Chrome":this.driverType=DriverType.CHROME;
                break;
            case "Firefox":this.driverType=DriverType.FIREFOX;
                break;
        }
        System.out.println("driver type is " +this.driverType);
    }
    private void configureEnvironmentType(String environmentValue){
        switch(environmentValue){
            case "Local":this.environmentType=EnvironmentType.LOCAL;
                break;
            case "Remote":this.environmentType=EnvironmentType.REMOTE;
                break;
        }System.out.println("evr type is "+this.environmentType);
    }

    public WebDriver createDriver()  {
        switch(environmentType) {
            case LOCAL: driver = createLocalWebdriver();
                break;
            case REMOTE : driver = createRemoteWebdriver();
            default:
                //throw new RuntimeException("Environment type is incorrect " +environmentType);
        }
        return driver;
    }

    private WebDriver createRemoteWebdriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalWebdriver()  {

        try{
            switch(driverType) {
                case CHROME :
                    WebDriverManager.chromedriver().version("84.0").setup();
                    driver=new ChromeDriver();
                    break;
                case FIREFOX :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                default:
            }}catch(Exception ae){
            ae.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.get(this.applicationUrl);
       // driver.get("https://extentreports.com/");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(this.implicitWaitTime, TimeUnit.SECONDS);
        System.out.println("Before return is "+driver);
        return driver;
    }











}
