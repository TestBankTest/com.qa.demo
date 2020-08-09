package com.qa.testdatautil;

public enum SheetNames {

    ProductInfoExcel_ProductInfo ("ProductInfo"),
    ProductInfoExcel_CasualDressInfo ("CasualDressInfo"),
    ProductInfoExcel_DiscountInfo ("Discount Info"),
    ProductInfoExcel_Popular ("Popular"),
    ProductInfoExcel_BestSeller ("BestSeller"),
    ProductInfoExcel_ProductList("ProductList"),
    ProductInfoExcel_UserDetails("UserDetails"),
    ProductInfoExcel_UserCredential("UserCredential"),
    ProductInfoExcel_OrderHistory("OrderHistory")



    ;

    private final String sheetName;
    SheetNames(String column){
        this.sheetName=column;
    }

    public String getSheetName(){
        return this.sheetName;
    }


}
