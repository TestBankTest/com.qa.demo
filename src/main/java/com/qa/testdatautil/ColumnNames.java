package com.qa.testdatautil;

public enum ColumnNames {

    ProductList_ProductId ("ProductId"),
    ProductList_ProductName ("ProductName"),
    ProductList_ProductPrice ("ProductPrice"),
    ProductList_ProductColor ("ProductColor"),
    ProductList_ProductSize ("ProductSize"),
    ProductList_PProductAvailabilityStatus ("ProductAvailabilityStatus"),

    UserDetails_UserID("UserID"),
    UserDetails_UserName("UserName"),
    UserDetails_FirstName("FirstName"),
    UserDetails_LastName("LastName"),
    UserDetails_CompanyName("CompanyName"),
    UserDetails_Address("Address"),
    UserDetails_AddressLineTwo("Address_Line_Two"),
    UserDetails_City("City"),
    UserDetails_State("State"),
    UserDetails_PostalCode("Postal Code"),
    UserDetails_CountryName("Country"),
    UserDetails_HomePhone("Home Phone"),
    UserDetails_MobileNumber("MobileNumber"),

    UserCredential_UserID("UserID"),
    UserCredential_UserName("Username"),
    UserCredential_UserPassword("Password"),

    OrderHistory_ReferenceNumber("ReferenceNumber"),
    OrderHistory_OrderDate("OrderDate"),
    OrderHistory_ProductName("ProductName"),
    OrderHistory_TotalPrice("Total Price"),
    OrderHistory_ProductQuantity("ProductQuantity"),
    OrderHistory_UnitPrice("Unit Price"),
    OrderHistory_PaymentMethod("Payment Method"),



    ;

    private final String columnName;
    ColumnNames(String column){
        this.columnName=column;
    }

    public String getColumnName(){
        return this.columnName;
    }

}
