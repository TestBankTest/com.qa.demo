package com.qa.testdatautil;

public enum ExcelFilesPath {


    ProductInfoExcel("./testdata/ProductData.xlsx"),
    ;

    private final String excelFilePath;
    ExcelFilesPath(String path){
        this.excelFilePath=path;
    }

    public String getExcelFilePath(){
        return this.excelFilePath;
    }



}
