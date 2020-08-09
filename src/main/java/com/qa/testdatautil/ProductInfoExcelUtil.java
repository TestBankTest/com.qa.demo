package com.qa.testdatautil;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

public class ProductInfoExcelUtil extends ExcelBaseUtil{

    ColumnNames columnNames;
    SheetNames sheetNames;
    public ProductInfoExcelUtil(String fileName, String filePath) {
        super(fileName, filePath);
    }

    public Object[][] getPopularProduct(String filename,String sheetName,Integer rowNo){
        Object[][] ProductInfo=null;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalRowCount=this.getTotalRowCount(sheet)-1;
            Integer totalColumnCount=this.getTotalColumnCount(sheet,rowNo);
            ProductInfo=new Object[totalRowCount][totalColumnCount];

            for(int i=0;i<totalRowCount;i++){
                for(int j=0;j<this.getTotalColumnCount(sheet,i);j++){
                    ProductInfo[i][j]=this.getData(sheet,(i+1),j);
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }return ProductInfo;
    }

    public String getProductName(String filename,String sheetName,Integer rowNo){
        String productName="";
        this.columnNames=ColumnNames.ProductList_ProductName;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            productName = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return productName;
    }

    public String getProductPrice(String filename,String sheetName,Integer rowNo){
        String productPrice="";
        this.columnNames=ColumnNames.ProductList_ProductPrice;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            productPrice = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return productPrice;
    }

    public String getProductColor(String filename,String sheetName,Integer rowNo){
        String productColor="";
        this.columnNames=ColumnNames.ProductList_ProductColor;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            productColor = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return productColor;
    }

    public String getProductSize(String filename,String sheetName,Integer rowNo){
        String productSize="";
        this.columnNames=ColumnNames.ProductList_ProductSize;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            productSize = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return productSize;
    }

    public Object[][] getPopularProductNameAndProductPrice(String filename,String sheetName,Integer rowNo){
        Object[][] productData=null;
        int ProductNameColumnIndex = 0;
        int ProductPriceColumnIndex= 0;
        String ProductNameColumnName="";
        String ProductPriceColumnName="";
        try {
            Sheet sheet = this.getSheet(this.getWorkbook(filename), sheetName);
            Integer totalColumnCount = this.getTotalColumnCount(sheet, 0);
            Integer totalRowCount = this.getTotalRowCount(sheet)-1;


            productData=new Object[totalRowCount][2];
            if (rowNo > totalRowCount) {

                //return null;
            } else{
                this.columnNames=ColumnNames.ProductList_ProductName;
                ProductNameColumnName=this.columnNames.getColumnName().toString();
                this.columnNames=ColumnNames.ProductList_ProductPrice;
                ProductPriceColumnName=this.columnNames.getColumnName().toString();

                for(int i=0;i<totalColumnCount;i++){
                    if(this.getData(sheet,0,i).trim().equals(ProductNameColumnName)){
                        ProductNameColumnIndex=i;
                    }
                    if(this.getData(sheet,0,i).trim().equals(ProductPriceColumnName) ){
                        ProductPriceColumnIndex=i;
                    }
                }
                for(int i=0;i<totalRowCount;i++){
                    for(int j=0;j<2;j++){
                        if(j==0){
                            productData[i][j]=this.getData(sheet,(i+1),ProductNameColumnIndex);
                        }else {
                            productData[i][j]=this.getData(sheet,(i+1),ProductPriceColumnIndex);
                        }
                    }
                }
            }

        }catch (Exception ae){
            ae.printStackTrace();
        }return productData;
    }

    public Object[][] getPopularProductNameAndProductPriceAndProductAvailabilityStatus(String filename,String sheetName,Integer rowNo){
        Object[][] productData=null;
        int ProductNameColumnIndex = 0;
        int ProductPriceColumnIndex= 0;
        int ProductAvailabilityStatusColumnIndex=0;
        String ProductNameColumnName="";
        String ProductPriceColumnName="";
        String ProductAvailabilityStatus="";
        try {
            Sheet sheet = this.getSheet(this.getWorkbook(filename), sheetName);
            Integer totalColumnCount = this.getTotalColumnCount(sheet, 0);
            Integer totalRowCount = this.getTotalRowCount(sheet)-1;


            productData=new Object[1][3];
            if (rowNo > totalRowCount) {

                //return null;
            } else{
                this.columnNames=ColumnNames.ProductList_ProductName;
                ProductNameColumnName=this.columnNames.getColumnName().toString();
                this.columnNames=ColumnNames.ProductList_ProductPrice;
                ProductPriceColumnName=this.columnNames.getColumnName().toString();
                this.columnNames=ColumnNames.ProductList_PProductAvailabilityStatus;
                ProductAvailabilityStatus=this.columnNames.getColumnName();

                for(int i=0;i<totalColumnCount;i++){
                    if(this.getData(sheet,0,i).trim().equals(ProductNameColumnName)){
                        ProductNameColumnIndex=i;
                    }
                    if(this.getData(sheet,0,i).trim().equals(ProductPriceColumnName) ){
                        ProductPriceColumnIndex=i;
                    }
                    if(this.getData(sheet,0,i).equals(ProductAvailabilityStatus)){
                        ProductAvailabilityStatusColumnIndex=i;
                    }
                }
                    for(int j=0;j<3;j++){
                        if(j==0){
                            productData[0][j]=this.getData(sheet,rowNo,ProductNameColumnIndex);
                        }else if(j==1){
                            productData[0][j]=this.getData(sheet,rowNo,ProductPriceColumnIndex);
                        }else if(j==2){
                            productData[0][j]=this.getData(sheet,rowNo,ProductAvailabilityStatusColumnIndex);
                        }
                }
            }

        }catch (Exception ae){
            ae.printStackTrace();
        }return productData;
    }

    public Integer getProductID(String filename,String sheetName,Integer rowNo){
        {
            Integer productID=null;
            this.columnNames=ColumnNames.ProductList_ProductId;
            try{
                Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
                Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
                Integer totalRowCount=this.getTotalRowCount(sheet);
                if(rowNo>totalRowCount){
                    System.out.println("Invalid rowNo");
                }else {
                    for (int i = 0; i < 1; i++) {
                        for (int j = 0; j < totalColumnCount; j++) {
                            if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                                productID = new Integer(Double.valueOf(Double.parseDouble(this.getData(sheet,rowNo,j))).intValue());
                            }
                        }
                    }
                }
            }catch (Exception ae){
                ae.printStackTrace();
            } return productID;
        }
    }

    public Object[][] getProductInfo(String filename,String sheetName,Integer rowNo){
        {
            Object[][] ProductInfo=null;
            try{
                Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
                Integer totalColumnCount=this.getTotalColumnCount(sheet,rowNo)-2;
                ProductInfo=new Object[1][totalColumnCount];
               System.out.println("Total column count is " +totalColumnCount);
                for(int i=0;i<totalColumnCount;i++){
                    System.out.println("Value is " +this.getData(sheet,rowNo,i));
                    ProductInfo[0][i]=this.getData(sheet,rowNo,(i+1));
                    System.out.println("Value is 2 " +ProductInfo[0][i]);
                }

            }catch (Exception ae){
                ae.printStackTrace();
            }return ProductInfo;
        }

    }

    public String getProductAvailabilityStatus(String filename,String sheetName,Integer rowNo){
        String productAvailabilityStatus=" ";
                try {
                    Sheet sheet = this.getSheet(this.getWorkbook(filename), sheetName);
                    Integer totalColumnCount = this.getTotalColumnCount(sheet, rowNo);
                    this.columnNames = ColumnNames.ProductList_PProductAvailabilityStatus;
                    for (int i = 0; i < totalColumnCount; i++) {
                        if (this.getData(sheet, 0, i).equals(this.columnNames.getColumnName().toString())) {
                            productAvailabilityStatus = this.getData(sheet, rowNo, i);
                        }
                    }
                }catch (Exception ae){
                    ae.printStackTrace();
                }return productAvailabilityStatus;
    }

    //=============================================================================================================


    public String getFirstName(String filename,String sheetName,Integer rowNo){
        String FirstName="";
        this.columnNames=ColumnNames.UserDetails_FirstName;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            FirstName = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return FirstName;
    }

    public String getLastName(String filename,String sheetName,Integer rowNo){
        String LastName="";
        this.columnNames=ColumnNames.UserDetails_LastName;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            LastName = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return LastName;
    }

    public String getCompanyName(String filename,String sheetName,Integer rowNo){
        String CompanyName="";
        this.columnNames=ColumnNames.UserDetails_CompanyName;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            CompanyName = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return CompanyName;
    }

    public String getAddress(String filename,String sheetName,Integer rowNo){

        String Address="";
        this.columnNames=ColumnNames.UserDetails_Address;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            Address = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return Address;
    }

    public String getAddressLineTwo(String filename,String sheetName,Integer rowNo){

        String AddressLineTwo="";
        this.columnNames=ColumnNames.UserDetails_AddressLineTwo;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            AddressLineTwo = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return AddressLineTwo;
    }

    public String getCity(String filename,String sheetName,Integer rowNo){

        String City="";
        this.columnNames=ColumnNames.UserDetails_City;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            City = this.getData(sheet,rowNo,j)+",";
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return City;
    }

    public String getState(String filename,String sheetName,Integer rowNo){

        String State="";
        this.columnNames=ColumnNames.UserDetails_State;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            State = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return State;
    }

    public Integer getPostalCode(String filename,String sheetName,Integer rowNo){

        Integer PostalCode=null;
        this.columnNames=ColumnNames.UserDetails_PostalCode;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            Double temp=Double.parseDouble(this.getData(sheet,rowNo,j));
                            PostalCode=temp.intValue();
                            temp=null;
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return PostalCode;
    }

    public String getCountryName(String filename,String sheetName,Integer rowNo){

        String CountryName="";
        this.columnNames=ColumnNames.UserDetails_CountryName;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            CountryName = this.getData(sheet,rowNo,j);
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return CountryName;
    }

    public Integer getHomeNumber(String filename,String sheetName,Integer rowNo){

        Integer HomeNumber=null;
        this.columnNames=ColumnNames.UserDetails_HomePhone;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            Double temp=Double.parseDouble(this.getData(sheet,rowNo,j));
                            HomeNumber=temp.intValue();
                            temp=null;                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return HomeNumber;
    }

    public Long getMobileNumber(String filename,String sheetName,Integer rowNo){

        Long MobileNumber=null;
        this.columnNames=ColumnNames.UserDetails_MobileNumber;
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            if(rowNo>totalRowCount){
                System.out.println("Invalid rowNo");
            }else {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < totalColumnCount; j++) {
                        if (this.getData(sheet, i, j).equals(this.columnNames.getColumnName())) {
                            //System.out.println("Now " +this.getData(sheet,rowNo,j));

                            Double temp=Double.parseDouble(this.getData(sheet,rowNo,j));
                            System.out.println("After " +temp);
                            MobileNumber=temp.longValue();
                            System.out.println("Mobi " +MobileNumber);
                            temp=null;
                        }
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        } return MobileNumber;
    }

    public String getUserID(String filename,String sheetName,String userName,String password){
        String UserName="";
        try{
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);

            System.out.println("Before kin row count " +totalRowCount);

            for(int i=1;i<totalRowCount;i++){
                if(this.getData(sheet,i,1).trim().equals(userName.trim())){
                    if(this.getData(sheet,i,2).trim().equals(password.trim())){
                        UserName=this.getData(sheet,i,0);
                        break;
                    }
                }
            }



        }catch (Exception ae){
            ae.printStackTrace();
        } return UserName;

    }

    public String getUserName(String filename,String sheetName,String userName,String passwordD){
        String UserName="";
        String userID="";
        try{
            userID=this.getUserID(filename,sheetName,userName,passwordD);
            this.sheetNames=SheetNames.ProductInfoExcel_UserDetails;
            sheetName=this.sheetNames.getSheetName().trim();
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);

            for(int i=1;i<totalRowCount;i++){
                if(this.getData(sheet,i,0).trim().equals(userID.trim())){
                    userName=this.getData(sheet,i,1);
                    break;
                }
            }



        }catch (Exception ae){
            ae.printStackTrace();
        } return userName;


    }

    //==========================================================================

    public void storeProductHistory(String filename,String sheetName,Map productHistoryData){
        try{

            Set<Map.Entry<String,String>> entry = productHistoryData.entrySet();
            Sheet sheet=this.getSheet(this.getWorkbook(filename),sheetName);
            Integer totalColumnCount=this.getTotalColumnCount(sheet,0);
            Integer totalRowCount=this.getTotalRowCount(sheet);
            for(Map.Entry<String,String> str : entry){
              for(int i=0;i<totalColumnCount;i++){
                  if(this.getData(sheet,0,i).trim().equals(str.getKey().trim())){
                      this.setData(sheet,totalRowCount,i,str.getValue().trim());
                  }
              }

            }



        }catch (Exception ae){
            ae.printStackTrace();
        }

    }












































}
