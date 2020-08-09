package com.qa.testconfigurationutil;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestConfigurationFileUtil {

        private File file;
        private FileInputStream fileInputStream;
        private Properties properties;
        private static Map<String,Properties> ConfigurationFiles;
        private ConfigurationFilesName configurationFilesNames;
        private static String fileName="";

    public TestConfigurationFileUtil(String filePath, ConfigurationFilesName configurationFileName){
        try{
            this.file=new File(filePath);
            this.configurationFilesNames=configurationFileName;
            this.fileInputStream=new FileInputStream(this.file);
            this.properties=getProperties();
            this.properties.load(this.fileInputStream);
            ConfigurationFiles=getConfigurationFiles();
            setConfigurationFile(this.configurationFilesNames.getConfigurationFile(),this.properties);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
        private void setConfigurationFile(String fileName,Properties properties){
        try{
            ConfigurationFiles.put(fileName,properties);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
        private Properties getProperties(){
        try{
            if(this.properties==null){
                return this.properties=new Properties();
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }return this.properties;
    }
        private Map<String,Properties> getConfigurationFiles(){
        try{
            if(ConfigurationFiles==null){
                return ConfigurationFiles=new HashMap<String, Properties>();
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }return ConfigurationFiles;
    }
        public String getPropertyValue(String fileName, String propertyName){
        String propertyValue="";
        System.out.println("File Name is "+fileName+"PropertyName is " +propertyName);
        try{
            if(this.fileName.length()==0){
                for (Map.Entry<String,Properties> entry :this.getConfigurationFiles().entrySet()){
                    if(entry.getKey().equals(fileName)){
                        properties=(Properties) entry.getValue();
                        propertyValue=this.properties.getProperty(propertyName.toString());
                        this.fileName=fileName;
                        break;
                    }
                }
            }else{
                if(this.fileName.equals(fileName)){
                    propertyValue=this.properties.getProperty(propertyName.toString());
                }else{
                    for (Map.Entry<String,Properties> entry :this.getConfigurationFiles().entrySet()){
                        if(entry.getKey().equals(fileName)){
                            properties=(Properties) entry.getValue();
                            propertyValue=properties.getProperty(propertyName.toString());
                            this.fileName=fileName;
                            break;
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }return propertyValue;
    }





}
