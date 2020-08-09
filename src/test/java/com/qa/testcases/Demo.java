package com.qa.testcases;

import com.qa.testbase.TestBase;
import com.qa.testdatautil.ColumnNames;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demo extends TestBase {


    @Test
    public void TC01(){

        String str1="12.00";
        System.out.println(Double.parseDouble(str1));

        /*
        System.out.println(Double.parseDouble(str1.replace("$","")));
        System.out.println(Double.parseDouble(str2.replace("$","")));

        if(Double.parseDouble(str1.replace("$",""))==Double.parseDouble(str2.replace("$",""))){
            System.out.println("Matched");
        }else {
            System.out.println("Not Matched");
        }
*/

    }









}
