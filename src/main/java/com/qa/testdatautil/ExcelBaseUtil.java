package com.qa.testdatautil;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExcelBaseUtil {

    private String filePath;
    private File src;
    private static Map<String,String>fileStorage=null;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private Workbook workbook;
    private static Map<String,Workbook>Excels;
    private Sheet sheet;
    private ColumnNames columnNames;
    private ExcelFilesPath excelFilesPath;
    private Row row;
    private XSSFCell cell;
    boolean flag=false;
    ExcelBaseUtil(String fileName,String filePath){
        try{
            if(!storeFiles(fileName,filePath)) {
                this.src = new File(filePath);
                this.fileInputStream = new FileInputStream(this.src);
                if (getExtension(filePath).equals("xlsx")) {
                    this.workbook = new XSSFWorkbook(this.fileInputStream);
                    if (this.Excels == null) {
                        this.Excels = new HashMap<String, Workbook>();
                        this.Excels.put(fileName, this.workbook);
                        System.out.println("File name is " +fileName);
                    }
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public boolean storeFiles(String fileName,String filePath){
        boolean flag=false;
        try{
            if(fileStorage==null){
                fileStorage=new HashMap<>();
                fileStorage.put(fileName,filePath);
            }else{
                Set<Map.Entry<String, String>> entry = this.fileStorage.entrySet();
                for (Map.Entry<String, String> file : entry) {
                    if(file.getKey().toString().trim().equals(fileName)){
                        flag=true;
                        break;
                    }
                } if(flag==false){
                    fileStorage.put(fileName,filePath);
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }return flag;
    }


    public String getExtension(String filePath){
        String extention="";
        try{
            for(int i=filePath.lastIndexOf(".")+1;i<filePath.length();i++){
                extention=extention+filePath.charAt(i);
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }return extention;
    }

    public Workbook getWorkbook(String fileName){
        Workbook workbook=null;
        try{
            System.out.println("excel file len " +this.Excels.size());
            for (Map.Entry<String,Workbook> entry: this.Excels.entrySet()) {
                if(entry.getKey().equals(fileName)){
                    workbook=entry.getValue();
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }if(workbook==null){
            throw new NullPointerException("Invalid file Name");
        }else{
           return workbook;
        }
    }

    public Sheet getSheet(Workbook workbook,String sheetName){
        Sheet sheet=null;
        try{
            sheet=workbook.getSheet(sheetName);
        }catch (Exception ae){
            ae.printStackTrace();
        }if(sheet==null){
            throw new NullPointerException("Invalid sheetname");
        }else{
            return sheet;
        }
    }

    public Integer getTotalRowCount(Sheet sheet){
        Integer totalRowCount=0;
        try{
            totalRowCount=sheet.getPhysicalNumberOfRows();
        }catch (Exception ae){
            ae.printStackTrace();
        }return totalRowCount;
    }

    public Integer getTotalColumnCount(Sheet sheet,Integer rowNo){
        Integer totalColumnCount=0;
        try{
           totalColumnCount=sheet.getRow(rowNo).getPhysicalNumberOfCells();
        }catch (Exception ae){
            ae.printStackTrace();
        }return totalColumnCount;
    }

    public String getData(Sheet sheet,int rowNo,int colNo){
        String cellValue="";
        try{
            CellType cellType=sheet.getRow(rowNo).getCell(colNo).getCellType();
            switch (cellType){
                case STRING:cellValue=sheet.getRow(rowNo).getCell(colNo).getStringCellValue();
                break;
                case BOOLEAN:cellValue=String.valueOf(sheet.getRow(rowNo).getCell(colNo).getBooleanCellValue());
                break;
                case NUMERIC:cellValue=String.valueOf(sheet.getRow(rowNo).getCell(colNo).getNumericCellValue());
                break;
                case BLANK: throw new Exception("Cell is blanked");
                default:throw new Exception("Cell Type not matched");
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }return cellValue;
    }

    public String getcellValue(Sheet sheet,Integer rowNo,String columnName){
        String cellValue="";
        try {
            for(int i=0;i<sheet.getRow(0).getPhysicalNumberOfCells();i++){
                if(getData(sheet,0,i).equals(columnName));{
                    cellValue=getData(sheet,rowNo,i);
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }return cellValue;
    }

    public void setFile(String filePath,String fileName){
        boolean flag=false;
        Set<Map.Entry<String,Workbook>> entry = this.Excels.entrySet();
        try{
            for(Map.Entry<String,Workbook> excel : entry){
                if(fileName.trim().equals(excel.getKey().toString().trim())){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                this.src=new File(filePath);
                this.fileInputStream=new FileInputStream(this.src);
                if(getExtension(filePath).equals("xlsx")){
                    this.workbook=new XSSFWorkbook(this.fileInputStream);
                    if(this.Excels==null) {
                        this.Excels = new HashMap<String, Workbook>();
                        this.Excels.put(fileName, this.workbook);
                    } }}

        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public FileOutputStream writeFile(String fileName,String filePath) {
        try {
            Set<Map.Entry<String, String>> entry = this.fileStorage.entrySet();
                for (Map.Entry<String, String> file : entry) {
                    if (fileName.trim().equals(file.getKey().toString().trim())) {
                        this.src=new File(file.getValue().toString().trim());
                        this.fileOutputStream = new FileOutputStream(this.src);
                        break;
                    }
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }return this.fileOutputStream;
        }

    public void setData(Sheet sheet,int row, int col, String data){
                try {
                    if(flag==false){
                        this.row=sheet.createRow(row);
                        flag=true;
                    }
                    this.row.createCell(col,CellType.STRING).setCellValue(data);
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            }

    public void writeData(String filePath,String fileName){
        try{
            this.getWorkbook(filePath).write(this.writeFile(filePath,fileName));
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    public void closeFile(){
        try{
            this.fileOutputStream.flush();
            this.fileOutputStream.close();
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }










}
