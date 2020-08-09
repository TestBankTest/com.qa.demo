package com.qa.testconfigurationutil;

public enum PropertyNames {

    //========================     Configure SystemConfigurationFile  =====================================//
    SystemConfiguration_HostName ("HostName"),
    SystemConfiguration_OperatingSystem ("OperatingSystem"),
    SystemConfiguration_PlatformName ("PlatformName"),
    SystemConfiguration_DepartmentName ("DepartmentName"),
    SystemConfiguration_TesterName ("TesterName"),

    //================================================================================================================//

    //=======================     Configure TestEnvironmentConfigurationInfo     =============================================//

    TestEnvironmentConfiguration_TestEnvironment ("TestEnvironment"),
    TestEnvironmentConfiguration_BrowserName ("BrowserName"),
    TestEnvironmentConfiguration_TWindowMaximizeStatus ("WindowMaximizeStatus"),
    TestEnvironmentConfiguration_ChromeDriverPath ("ChromeDriverPath"),
    TestEnvironmentConfiguration_FirefoxDriverPath ("FirefoxDriverPath"),
    TestEnvironmentConfiguration_SanityApplicationUrl ("SanityApplicationUrl"),
    TestEnvironmentConfiguration_ProductionApplicationUrl ("ProductionApplicationUrl"),
    TestEnvironmentConfiguration_PageLoadTimeOut ("PageLoadTimeOut"),
    TestEnvironmentConfiguration_ImplicitWaitTimeOut ("ImplicitWaitTimeOut"),

    //=======================================================================================================================

    //================================================   Configure TestDataExcelFileConfiguration ====================================

    TestDataExcelLocation_ProductionTestDataFile("ProductionTestDataFile"),


    ;

    private final String property;
    PropertyNames(String property){
        this.property=property;
    }

    public String getProperty(){
        return this.property;
    }

}
