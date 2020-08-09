package com.qa.testconfigurationutil;

public enum ConfigurationFilesName {

    TestEnvironmentConfigurationFile ("TestEnvironment Configuration"),
    SystemConfigurationInfoFile ("System Configuration"),
    TestDataExcelFileLocation ("TestDataExcelLocation")
    ;

    private final String configurationFile;
    ConfigurationFilesName(String file){
        this.configurationFile=file;
    }

    public String getConfigurationFile(){
        return this.configurationFile;
    }


}
